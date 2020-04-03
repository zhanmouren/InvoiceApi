package com.korosoft.invoice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.korosoft.invoice.authority.annotation.LogType;
import com.korosoft.invoice.authority.annotation.Validation;
import com.korosoft.invoice.form.CancelForm;
import com.korosoft.invoice.form.InvoiceForm;
import com.korosoft.invoice.form.QueryDetailedForm;
import com.korosoft.invoice.form.QueryStockForm;
import com.korosoft.invoice.service.Contans;
import com.korosoft.invoice.service.SpecialInvoiceService;
import com.korosoft.invoice.vo.ResponseData;

/**
 * 专票控制层
 * @author zhoulibin
 *
 */
@RestController
@RequestMapping("/special")
public class SpecialInvoiceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpecialInvoiceController.class);
	
	private SpecialInvoiceService specialInvoiceService;
	
	@Autowired
	public SpecialInvoiceController(SpecialInvoiceService specialInvoiceService) {
		this.specialInvoiceService = specialInvoiceService;
	}
	
	/**
	 * 开专票
	 * @param data
	 * @return
	 */
	@Validation
	//@LogType("专票开具")
	@PostMapping("/open")
	public ResponseData open(@Valid @RequestBody InvoiceForm form, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				return ResponseData.faill(error.getDefaultMessage());
			}
		}
		request.setAttribute(Contans.GROUP_CODE, form.getGroup());
		String billFlag = request.getHeader("billFlag");
		if(StringUtils.isBlank(billFlag)) {
			return ResponseData.faill("请在请求头中设置【 " + billFlag + " 】");
		}
		return specialInvoiceService.open(form.getGroup(), Integer.parseInt(billFlag), form.getData());
	}
	
	/**
	 * 查询库存
	 * @param groupCode
	 * @param saleCreditCode
	 * @return
	 */
	@Validation
	//@LogType("库存查询")
	@PostMapping("/queryStock")
	public ResponseData queryStock(@Valid @RequestBody QueryStockForm form, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				return ResponseData.faill(error.getDefaultMessage());
			}
		}
		request.setAttribute(Contans.GROUP_CODE, form.getGroup());
		return specialInvoiceService.queryStock(form.getGroup(), form.getData().getSaleCreditCode());
	}
	
	/**
	 * 查询明细
	 * @param groupCode
	 * @param invoiceCode
	 * @param invoiceNumber
	 * @return
	 */
	@Validation
	//@LogType("发票明细查询")
	@PostMapping("/queryDetailed")
	public ResponseData queryDetailed(@Valid @RequestBody QueryDetailedForm form, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				return ResponseData.faill(error.getDefaultMessage());
			}
		}
		request.setAttribute(Contans.GROUP_CODE, form.getGroup());
		return specialInvoiceService.queryDetailed(form.getGroup(), form.getData().getInvoiceCode(), form.getData().getInvoiceNumber());
	}
	
	/**
	 * 专票撤回
	 * @param groupCode
	 * @param invoiceCode
	 * @param invoiceNumber
	 * @return
	 */
	@Validation
	//@LogType("专票撤回")
	@PostMapping("/cancel")
	public ResponseData cancel(@Valid @RequestBody CancelForm form, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				return ResponseData.faill(error.getDefaultMessage());
			}
		}
		request.setAttribute(Contans.GROUP_CODE, form.getGroup());
		return specialInvoiceService.cancel(form.getGroup(), form.getData().getBillBatchNo(), form.getData().getBillCode());
	}
}
