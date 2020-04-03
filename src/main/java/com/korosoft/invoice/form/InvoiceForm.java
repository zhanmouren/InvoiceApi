package com.korosoft.invoice.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.korosoft.invoice.dto.InvoiceInfoDto;

public class InvoiceForm {
	
	@NotNull(message = "字段【group】不能为空")
	private Integer group;
	
	@NotBlank(message = "字段【channel】不能为空")
	private String channel;
	
	private InvoiceInfoDto data;

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

	public InvoiceInfoDto getData() {
		return data;
	}

	public void setData(InvoiceInfoDto data) {
		this.data = data;
	}
}
