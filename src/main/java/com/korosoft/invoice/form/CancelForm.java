package com.korosoft.invoice.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CancelForm {
	
	@NotNull(message = "字段【group】不能为空")
	private Integer group;
	
	@NotBlank(message = "字段【channel】不能为空")
	private String channel;
	
	@NotNull(message = "字段【data】不能为空")
	private Cancel data;
	
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



	public Cancel getData() {
		return data;
	}



	public void setData(Cancel data) {
		this.data = data;
	}



	public class Cancel{
		
		private String billBatchNo;
		
		private String billCode;

		public String getBillBatchNo() {
			return billBatchNo;
		}

		public void setBillBatchNo(String billBatchNo) {
			this.billBatchNo = billBatchNo;
		}

		public String getBillCode() {
			return billCode;
		}

		public void setBillCode(String billCode) {
			this.billCode = billCode;
		}
	}
}
