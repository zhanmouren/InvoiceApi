package com.korosoft.invoice.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.korosoft.invoice.service.CallbackService;
import com.korosoft.invoice.util.AesUtil;
import com.korosoft.invoice.vo.ResponseData;

@RestController
public class CallbackController {
	
	private static final Logger LOGG = LoggerFactory.getLogger(CallbackController.class);
	
	private CallbackService callbackService;
	
	@Autowired
	public CallbackController(CallbackService callbackService) {
		this.callbackService = callbackService;
	}
	
	@PostMapping("/httpServer")
	public String callback(@RequestBody Map<String, String> data, HttpServletRequest request) {
		String groupCode = request.getParameter("groupCode");
		if(StringUtils.isBlank(groupCode)) {
			LOGG.error("回调失败：参数【groupCode】不能为空");
			return "false";
		}
		String billType = data.get("billType");
		if(StringUtils.isBlank(billType)) {
			LOGG.error("回调失败：参数【billType】不能为空");
			return "false";
		}
		String value = data.get("value");
		if(StringUtils.isBlank(value)) {
			LOGG.error("回调失败：参数【value】不能为空");
			return "false";
		}
		try {
			value = AesUtil.decrypt(value);
		} catch (Exception e) {
			LOGG.error("回调失败：参数解密失败");
			return "false";
		}
		JSONObject json = JSONObject.parseObject(value);
		if(StringUtils.isBlank(json.getString("billMoney"))) {
			LOGG.error("回调失败：参数【billMoney】不能为空");
			return "false";
		}
		if(StringUtils.isBlank(json.getString("kpMan"))) {
			LOGG.error("回调失败：参数【kpMan】不能为空");
			return "false";
		}
		if(StringUtils.isBlank(json.getString("invoiceNumber"))) {
			LOGG.error("回调失败：参数【invoiceNumber】不能为空");
			return "false";
		}
		if(StringUtils.isBlank(json.getString("billCode"))) {
			LOGG.error("回调失败：参数【billCode】不能为空");
			return "false";
		}
		if(StringUtils.isBlank(json.getString("billPrintState"))) {
			LOGG.error("回调失败：参数【billPrintState】不能为空");
			return "false";
		}
		if(StringUtils.isBlank(json.getString("invoiceCode"))) {
			LOGG.error("回调失败：参数【invoiceCode】不能为空");
			return "false";
		}
		ResponseData result = callbackService.callback(Integer.parseInt(groupCode), json);
		if(ResponseData.SUCCESS_CODE == result.getCode()) {
			return "true";
		}else {
			LOGG.error("回调失败：{}", result.getMessage());
			return "false";
		}
	}
}
