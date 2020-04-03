package com.korosoft.invoice.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QueryStockForm {
	
	@NotNull(message = "字段【group】不能为空")
	private Integer group;
	
	@NotBlank(message = "字段【channel】不能为空")
	private String channel;
	
	@NotNull(message = "字段【data】不能为空")
	private QueryStock data; 
	
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

	public QueryStock getData() {
		return data;
	}

	public void setData(QueryStock data) {
		this.data = data;
	}

	public class QueryStock {
		
		private String saleCreditCode;

		public String getSaleCreditCode() {
			return saleCreditCode;
		}

		public void setSaleCreditCode(String saleCreditCode) {
			this.saleCreditCode = saleCreditCode;
		}
	}

}
