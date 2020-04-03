package com.korosoft.invoice.bean.query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SysLogQueryBean extends BaseQueryBean{

	/**开始日期*/
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date beginDate;		
	
	/**结束日期*/
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endDate;		
	
	/**公司编码*/
	private String groupCode;
	
	/**公司名称*/
	private String groupName;

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
