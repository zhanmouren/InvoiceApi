package com.korosoft.invoice.service;

import com.korosoft.invoice.vo.ResponseData;

/**
 * 专票
 * @author 59532
 *
 */
public interface SpecialInvoiceService extends InvoiceService{
	
	/**
	 * 专票撤销
	 * @return
	 */
	ResponseData cancel(int groupCode, String billBatchNo, String billCode);

}
