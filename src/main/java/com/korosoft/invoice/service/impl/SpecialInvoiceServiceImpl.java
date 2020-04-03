package com.korosoft.invoice.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.korosoft.invoice.bean.SysConfigBean;
import com.korosoft.invoice.dto.InvoiceInfoDto;
import com.korosoft.invoice.service.SpecialInvoiceService;
import com.korosoft.invoice.service.SysConfigService;
import com.korosoft.invoice.util.AesUtil;
import com.korosoft.invoice.util.HttpUtils;
import com.korosoft.invoice.vo.ResponseData;
import com.korosoft.invoice.vo.ResultData;

/**
 * 专票业务逻辑层
 * @author 59532
 *
 */
@Service
public class SpecialInvoiceServiceImpl extends AbstractInvoiceService implements SpecialInvoiceService{
	
	private static final Logger LOG = LoggerFactory.getLogger(SpecialInvoiceServiceImpl.class);

	@Autowired
	public SpecialInvoiceServiceImpl(SysConfigService sysConfigService) {
		super.sysConfigService = sysConfigService;
	}
	
	@Override
	public ResponseData open(int groupCode, int billFlag, InvoiceInfoDto data) {
		InvoiceInfoDto dto = generateInvoiceInfoDto(groupCode, data);
		String params = JSONObject.toJSONString(dto);
		Map<String, String> headers = new HashMap<>();
		if(billFlag == 1){
			headers.put("busSysId", dto.getBusSysId());
			headers.put("SID", "1001");
			headers.put("Content-Type", "application/json");
		}else{
			headers.put("busSysId", dto.getBusSysId());
			headers.put("SID", "1007");
			headers.put("Content-Type", "application/json");
		}
		try {
			params = AesUtil.encrypt(params);
			String result = HttpUtils.doPost(etcloudApiUrl, params, headers);
			ResultData resultData = JSONObject.parseObject(result, ResultData.class);
			if(Objects.equals("false", resultData.getSuccess())) {
				LOG.info("专票开票失败：{}", resultData.getMessage());
				return ResponseData.faill("专票开票失败:" + resultData.getMessage());
			}else {
				String value = resultData.getValue();
				value = AesUtil.decrypt(value);
				LOG.info("专票开票成功,发票号码：{}", data.getBillBatchNo());
				return ResponseData.success(value, "专票开票成功");
			}
		}catch(Exception ex) {
			LOG.error("接口服务平台专票开票执行失败：{}", ex.getMessage());
			return ResponseData.faill("接口服务平台专票开票执行失败:" + ex.getMessage());
		}
	}

	/**
	 * 发票撤回
	 */
	@Override
	public ResponseData cancel(int groupCode, String billBatchNo, String billCode) {
		SysConfigBean sysConfig = getSysConfig(groupCode);
		Map<String, String> map = new HashMap<String, String>();
		map.put("billBatchNo", billBatchNo);
		map.put("billCode", billCode);
		map.put("busSysId", Integer.toString(sysConfig.getBusSysId()));
		map.put("busSysName", sysConfig.getBusSysName());
		map.put("busUserName", sysConfig.getBusUserName());
		map.put("busUserPwd", sysConfig.getBusUserPwd());
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("busSysId", Integer.toString(sysConfig.getBusSysId()));
		headers.put("SID", "1003");
		headers.put("Content-Type", "application/json");
		String params = JSONObject.toJSONString(map);
		try {
			params = AesUtil.encrypt(params);
			String result = HttpUtils.doPost(etcloudApiUrl, params, headers);
			ResultData resultData = JSONObject.parseObject(result, ResultData.class);
			if(Objects.equals("false", resultData.getSuccess())) {
				LOG.info("发票撤回失败：{}", resultData.getMessage());
				return ResponseData.faill("发票撤回失败:" + resultData.getMessage());
			}else {
				String value = resultData.getValue();
				value = AesUtil.decrypt(value);
				LOG.info("专票撤回执行成功,发票号码：{}", billBatchNo);
				return ResponseData.success(value, "专票撤回执行成功");
			}
		} catch (Exception e) {
			LOG.error("接口服务平台专票撤回执行出错：{}", e.getMessage());
			return ResponseData.faill("接口服务平台专票撤回执行出错:" + e.getMessage());
		}
	}
}
