package com.korosoft.invoice.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QueryDetailedForm {
	
	@NotNull(message = "字段【group】不能为空")
	private Integer group;
	
	@NotBlank(message = "字段【channel】不能为空")
	private String channel;
	
	@NotNull(message = "字段【data】不能为空")
	private QueryDetailed data;
	
	
	public Integer getGroup() {
		return group;
	}



	public void setGroup(Integer group) {
		this.group = group;
	}



	public String getChannel() {
		return channel;
	}



	public void setChannel(String channel) {
		this.channel = channel;
	}



	public QueryDetailed getData() {
		return data;
	}



	public void setData(QueryDetailed data) {
		this.data = data;
	}



	public class QueryDetailed{
		
		private String invoiceCode;
		
		private String invoiceNumber;

		public String getInvoiceCode() {
			return invoiceCode;
		}

		public void setInvoiceCode(String invoiceCode) {
			this.invoiceCode = invoiceCode;
		}

		public String getInvoiceNumber() {
			return invoiceNumber;
		}

		public void setInvoiceNumber(String invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
		}
	}
}
