package com.korosoft.invoice.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.korosoft.invoice.controller.ElectronicInvoiceController;
import com.korosoft.invoice.dto.InvoiceInfoDto;
import com.korosoft.invoice.dto.SendMailDto;
import com.korosoft.invoice.form.SendMailForm;
import com.korosoft.invoice.service.ElectronicInvoiceService;
import com.korosoft.invoice.service.SysConfigService;
import com.korosoft.invoice.util.AesUtil;
import com.korosoft.invoice.util.HttpUtils;
import com.korosoft.invoice.vo.ResponseData;
import com.korosoft.invoice.vo.ResultData;

/**
 * 电子票业务逻辑层
 * 
 * @author 59532
 *
 */
@Service
public class ElectronicInvoiceServiceImpl extends AbstractInvoiceService implements ElectronicInvoiceService {

	private static final Logger LOG = LoggerFactory.getLogger(ElectronicInvoiceController.class);
	
	@Autowired
	public ElectronicInvoiceServiceImpl(SysConfigService sysConfigService) {
		super.sysConfigService = sysConfigService;
	}

	@Override
	public ResponseData open(int groupCode, int billFlag, InvoiceInfoDto data) {
		InvoiceInfoDto dto = generateInvoiceInfoDto(groupCode, data);
		String params = JSONObject.toJSONString(dto);
		System.out.println("1111111"+params);
		Map<String, String> headers = new HashMap<>();
		headers.put("busSysId", dto.getBusSysId());
		headers.put("SID", "1009");
		headers.put("Content-Type", "application/json");
		try {
			params = AesUtil.encrypt(params);
			String result = HttpUtils.doPost(etcloudApiUrl, params, headers);
			ResultData resultData = JSONObject.parseObject(result, ResultData.class);
			if (Objects.equals("false", resultData.getSuccess())) {
				LOG.info("电子票开票失败：{}", resultData.getMessage());
				return ResponseData.faill("电子票开票失败:" + resultData.getMessage());
			} else {
				String value = resultData.getValue();
				value = AesUtil.decrypt(value);
				LOG.info("电子票开票成功, 发票号码：{}", data.getBillBatchNo());
				return ResponseData.success(value, "电子票开票成功");
			}
		} catch (Exception ex) {
			LOG.error("接口服务平台电子票执行失败：{}", ex.getMessage());
			return ResponseData.faill("接口服务平台电子票执行失败:" + ex.getMessage());
		}
	}

	@Override
	public ResponseData queryTaxDisk(Integer group, String creditCode, String diskCode, String invType) {
		return null;
	}


	@Override
	public ResponseData sendMail(String userName, String invoice_address, String toEmail) {
		
		try {
			SendMailDto mail = new SendMailDto();
			Properties prop = new Properties();
			prop.load(new InputStreamReader(TaskScheduler.class.getClassLoader().getResourceAsStream("config.properties"), "UTF-8"));
			mail.setStrHost(prop.getProperty("email.host").trim()); 
			mail.setStrFrom(prop.getProperty("email.from").trim());
			mail.setStrEmailUserName(prop.getProperty("email.username").trim());
			mail.setStrEmailPassword(prop.getProperty("email.password").trim());
			mail.setEmailTitle(prop.getProperty("email.title").trim()); 
			String strArrTo[] = toEmail.split(",");
			Properties props = new Properties();
			Address[] tos = null;
			if (strArrTo != null && strArrTo.length != 0) {
				tos = new InternetAddress[strArrTo.length];
				for (int i = 0; i < strArrTo.length; i++) {
					String s = strArrTo[i];
					tos[i] = new InternetAddress(s);
				}
			}

			// Setup mail server
			props.put("mail.smtp.host", mail.getStrHost());
			props.put("mail.smtp.auth", "true"); // 这样才能通过验证
			// Get session
			Session session = Session.getDefaultInstance(props);

			// watch the mail commands go by to the mail server
			session.setDebug(true);
			// Define message
			MimeMessage message = new MimeMessage(session);
			message.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
			message.setFrom(new InternetAddress(mail.getStrFrom()));
			// message.addRecipient(Message.RecipientType.TO,new
			// InternetAddress(to));

			message.setRecipients(Message.RecipientType.TO, tos);
		
			message.setSentDate(new Date());
			message.setSubject(""); // 标题
			message.setText(invoice_address); // 内容
			// Send message
			message.setContent(invoice_address.toString(), "text/html;charset=utf-8");
			message.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(mail.getStrHost(), mail.getStrEmailUserName(), mail.getStrEmailPassword());
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			LOG.info("邮件发送成功, 邮箱地址：{}",toEmail);
			return ResponseData.success("true", "电子票开票成功");
		} catch (IOException e) {	
			LOG.error("接口服务平台邮件发送失败：{}", e.getMessage());
			return ResponseData.faill("接口服务平台邮件发送失败:" + e.getMessage());
		}  catch (MessagingException e) {
			LOG.error("接口服务平台邮件发送失败：{}", e.getMessage());
			return ResponseData.faill("接口服务平台邮件发送失败:" + e.getMessage());			
		}
	}
}