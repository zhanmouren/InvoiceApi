package com.korosoft.invoice.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.korosoft.invoice.bean.SysConfigBean;
import com.korosoft.invoice.service.CallbackService;
import com.korosoft.invoice.service.SysConfigService;
import com.korosoft.invoice.util.HttpUtils;
import com.korosoft.invoice.vo.ResponseData;

@Service
public class CallbackServiceImpl implements CallbackService{
	
	private SysConfigService sysConfigService;
	
	@Autowired
	public CallbackServiceImpl(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}

	@Override
	public ResponseData callback(int groupCode, JSONObject data) {
		SysConfigBean sysConfig = sysConfigService.getSysConfigByGroupCode(groupCode);
		if(StringUtils.isBlank(sysConfig.getBackUrl())) {
			return ResponseData.faill("发票回调失败：请先配置发票回调地址");
		}
		String params = data.toJSONString();
		Map<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		try {
			String message = HttpUtils.doPost(sysConfig.getBackUrl(), params, header);
			if(Objects.equals("false", message)) {
				return ResponseData.faill("接口回调失败：{}", message);
			}else {
				return ResponseData.success("接口回调执行成功");
			}
		} catch (Exception e) {
			return ResponseData.faill("接口服务平台接口回调执行失败");
		}
	}
}
