package com.korosoft.invoice.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QueryTaxDiskFrom {
	
	@NotNull(message = "字段【group】不能为空")
	private Integer group;
	
	@NotBlank(message = "字段【channel】不能为空")
	private String channel;
	
	@NotNull(message = "字段【data】不能为空")
	private QueryTaxDisk data; 
	
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

	public QueryTaxDisk getData() {
		return data;
	}

	public void setData(QueryTaxDisk data) {
		this.data = data;
	}

	public class QueryTaxDisk {
		
		private String creditCode;
		private String diskCode;
		private String invType;
		public String getCreditCode() {
			return creditCode;
		}
		public void setCreditCode(String creditCode) {
			this.creditCode = creditCode;
		}
		public String getDiskCode() {
			return diskCode;
		}
		public void setDiskCode(String diskCode) {
			this.diskCode = diskCode;
		}
		public String getInvType() {
			return invType;
		}
		public void setInvType(String invType) {
			this.invType = invType;
		}
		
	}

}
