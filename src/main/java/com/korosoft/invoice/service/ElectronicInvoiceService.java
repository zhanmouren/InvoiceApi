package com.korosoft.invoice.service;

import com.korosoft.invoice.form.SendMailForm;
import com.korosoft.invoice.vo.ResponseData;

/**
 * 电子发票
 * @author 59532
 *
 */
public interface ElectronicInvoiceService extends InvoiceService{

	ResponseData queryTaxDisk(Integer group, String creditCode, String diskCode, String invType);

	ResponseData sendMail(String userName, String invoice_address, String toEmail);

}
