package com.korosoft.invoice.service;


import com.korosoft.invoice.dto.InvoiceInfoDto;
import com.korosoft.invoice.form.SendMailForm;
import com.korosoft.invoice.vo.ResponseData;

public interface InvoiceService {
	
	/**
	 * 开票
	 * @param billFlag 
	 * @return
	 */
	ResponseData open(int groupCode, int billFlag, InvoiceInfoDto data);
	
	/**
	 * 查询库存
	 * @return
	 */
	ResponseData queryStock(int groupCode, String saleCreditCode);
	
	/**
	 * 查询明细
	 * @return
	 */
	ResponseData queryDetailed(int groupCode, String invoiceCode, String invoiceNumber);
	
	
}
