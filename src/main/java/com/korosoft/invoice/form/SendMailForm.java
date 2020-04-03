package com.korosoft.invoice.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SendMailForm {
	@NotNull(message = "字段【userName】不能为空")
	private String userName;
	
	@NotBlank(message = "字段【invoice_address】不能为空")
	private String invoice_address;
	
	@NotNull(message = "字段【toEmail】不能为空")
	private String toEmail ;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInvoice_address() {
		return invoice_address;
	}

	public void setInvoice_address(String invoice_address) {
		this.invoice_address = invoice_address;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	} 

}
