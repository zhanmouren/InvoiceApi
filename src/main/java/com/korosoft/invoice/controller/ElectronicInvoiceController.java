package com.korosoft.invoice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.korosoft.invoice.service.*;
import com.korosoft.invoice.vo.ResponseData;
import com.korosoft.invoice.authority.annotation.LogType;
import com.korosoft.invoice.authority.annotation.StaffAttribute;
import com.korosoft.invoice.authority.annotation.Validation;
import com.korosoft.invoice.bean.SysUserBean;
import com.korosoft.invoice.service.Contans;
import com.korosoft.invoice.form.InvoiceForm;
import com.korosoft.invoice.form.QueryTaxDiskFrom;
import com.korosoft.invoice.form.SendMailForm;

/**
 * 电子票
 * 
 * @author 59532
 *
 */
@RestController
public class ElectronicInvoiceController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ElectronicInvoiceController.class);

	@Autowired
	private ElectronicInvoiceService InvoiceService;
	

	@Validation
	//@LogType("电子发票开具")
	@PostMapping("/electronic")
	public ResponseData open(@Valid @RequestBody InvoiceForm form, HttpServletRequest request) throws Exception {
		if (form.getGroup() == null) {
			return ResponseData.faill("参数【group】不能为空!");
		}
		if (form.getData() == null) {
			return ResponseData.faill("参数【BillDetailApiList】不能为空!");
		}
		request.setAttribute(Contans.GROUP_CODE, form.getGroup());
		return InvoiceService.open(form.getGroup(), 1, form.getData());
	}
	
	@Validation
	@PostMapping("/taxDisk")
	public ResponseData queryTaxDisk(@RequestBody QueryTaxDiskFrom form, HttpServletRequest request) throws Exception {
		if (form.getGroup() == null) {
			return ResponseData.faill("参数【group】不能为空!");
		}
		if (form.getData() == null) {
			return ResponseData.faill("参数【BillDetailApiList】不能为空!");
		}
		request.setAttribute(Contans.GROUP_CODE, form.getGroup());
		return InvoiceService.queryTaxDisk(form.getGroup(), form.getData().getCreditCode(), form.getData().getDiskCode(),form.getData().getInvType());
	}
	
	@Validation
	@PostMapping("/sendMail")
	public ResponseData sendMail(@RequestBody SendMailForm form, HttpServletRequest request) throws Exception {
		if (form.getUserName() == null) {
			return ResponseData.faill("参数【username】不能为空!");
		}
		if (form.getInvoice_address() == null) {
			return ResponseData.faill("参数【invoice_address】不能为空!");
		}
		if (form.getToEmail() == null) {
			return ResponseData.faill("参数【toEmail】不能为空!");
		}
		return InvoiceService.sendMail(form.getUserName(),form.getInvoice_address(),form.getToEmail());
	}
	
}
