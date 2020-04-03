package com.korosoft.invoice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSONObject;
import com.korosoft.invoice.bean.SysConfigBean;
import com.korosoft.invoice.dto.InvoiceInfoDto;
import com.korosoft.invoice.service.InvoiceService;
import com.korosoft.invoice.service.SysConfigService;
import com.korosoft.invoice.util.AesUtil;
import com.korosoft.invoice.util.HttpUtils;
import com.korosoft.invoice.vo.ResponseData;
import com.korosoft.invoice.vo.ResultData;

public abstract class AbstractInvoiceService implements InvoiceService{
	
	private static final Logger LOG = LoggerFactory.getLogger(AbstractInvoiceService.class);
	
	@Value("${app.etcloud.apiUrl}")
	protected String etcloudApiUrl;
	
	public SysConfigService sysConfigService;
	
	protected SysConfigBean getSysConfig(int groupCode) {
		return sysConfigService.getSysConfigByGroupCode(groupCode);
	}
	
	/**
	 * 通用的方法生成发票的数据
	 * @param data
	 * @return
	 */
	protected InvoiceInfoDto generateInvoiceInfoDto(int groupCode, InvoiceInfoDto data) {
		SysConfigBean sysConfig =  getSysConfig(groupCode);
		data.setBusSysId(Integer.toString(sysConfig.getBusSysId()));
		data.setBusSysName(sysConfig.getBusSysName());
		data.setBusUserName(sysConfig.getBusUserName());
		data.setBusUserPwd(sysConfig.getBusUserPwd());
		data.setSaleName(sysConfig.getSaleName());
		data.setSalePhone(sysConfig.getSalePhone());
		data.setSaleAddress(sysConfig.getSaleAddress());
		data.setSaleBank(sysConfig.getSaleBank());
		data.setSaleBankAccount(sysConfig.getSaleBankAccount());
		data.setSaleCreditCode(sysConfig.getSaleCreditCode());
        data.setInvoiceAuto(sysConfig.getInvoiceAuto());
		data.setIsTax(sysConfig.getIsTax());		
		data.setInvoiceOrgCode(sysConfig.getInvoiceOrgCode());
		return data;
	}
	
	/**
	 * 查询库存
	 * @return
	 */
	public ResponseData queryStock(int groupCode, String saleCreditCode) {
		SysConfigBean sysConfig = getSysConfig(groupCode);
		Map<String, String> map = new HashMap<String, String>();
		map.put("saleCreditCode", saleCreditCode);
		map.put("busSysId", Integer.toString(sysConfig.getBusSysId()));
		map.put("busSysName", sysConfig.getBusSysName());
		map.put("busUserName", sysConfig.getBusUserName());
		map.put("busUserPwd", sysConfig.getBusUserPwd());
		Map<String, String> headers = new HashMap<>();
		headers.put("busSysId", Integer.toString(sysConfig.getBusSysId()));
		headers.put("SID", "1010");
		headers.put("Content-Type", "application/json");
		String params = JSONObject.toJSONString(map);
		try {
			params = AesUtil.encrypt(params);
			String result = HttpUtils.doPost(etcloudApiUrl, params, headers);
			ResultData resultData = JSONObject.parseObject(result, ResultData.class);
			if(Objects.equals("false", resultData.getSuccess())) {
				LOG.info("查询库存失败：{}", resultData.getMessage());
				return ResponseData.faill("查询库存失败:" + resultData.getMessage());
			}else {
				String value = resultData.getValue();
				value = AesUtil.decrypt(value);
				LOG.info("查询库存成功");
				return ResponseData.success(value, "查询库存成功");
			}
		} catch (Exception e) {
			LOG.error("接口平台查询库存执行失败：{}", e.getMessage());
			return ResponseData.faill("接口平台查询库存执行失败:" + e.getMessage());
		}
	};
	
	/**
	 * 查询明细
	 * @return
	 */
	public ResponseData queryDetailed(int groupCode, String invoiceCode, String invoiceNumber) {
		SysConfigBean sysConfig = getSysConfig(groupCode);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> p = new HashMap<String, String>();
		p.put("billBatchNo", invoiceNumber);
		p.put("billCode", invoiceCode);
		list.add(p);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("busSysId", Integer.toString(sysConfig.getBusSysId()));
		map.put("busSysName", sysConfig.getBusSysName());
		map.put("busUserName", sysConfig.getBusUserName());
		map.put("busUserPwd", sysConfig.getBusUserPwd());
		map.put("billList", list);
		Map<String, String> headers = new HashMap<>();
		headers.put("busSysId", Integer.toString(sysConfig.getBusSysId()));
		headers.put("SID", "1005");
		headers.put("Content-Type", "application/json");
		String params = JSONObject.toJSONString(map);
		LOG.info("明细查询入参：{}", params);
		try {
			params = AesUtil.encrypt(params);
			String result = HttpUtils.doPost(etcloudApiUrl, params, headers);
			ResultData resultData = JSONObject.parseObject(result, ResultData.class);
			if(Objects.equals("false", resultData.getSuccess())) {
				LOG.info("发票明细查询失败：{}", resultData.getMessage());
				return ResponseData.faill("发票明细查询失败:" + resultData.getMessage());
			}else {
				String value = resultData.getValue();
				value = AesUtil.decrypt(value);
				LOG.info("发票明细查询成功");
				return ResponseData.success(value, "发票明细查询成功");
			}
		} catch (Exception e) {
			LOG.error("接口平台发票明细查询失败：{}", e.getMessage());
			return ResponseData.faill("接口平台发票明细查询失败:" + e.getMessage());
		}
	}
}
