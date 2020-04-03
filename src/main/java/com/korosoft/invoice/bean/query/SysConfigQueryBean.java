package com.korosoft.invoice.bean.query;

public class SysConfigQueryBean extends BaseQueryBean{

	/**水司编号*/
	private String groupCode;
	
	/**水司名称*/
	private String groupName;
	
	/**E税云系统编号*/
	private Integer busSysId;
	
	/**E税云系统名称*/
	private String busSysName;
	
	/**E税云系统用户名*/
	private String busUserName;

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

	public Integer getBusSysId() {
		return busSysId;
	}

	public void setBusSysId(Integer busSysId) {
		this.busSysId = busSysId;
	}

	public String getBusSysName() {
		return busSysName;
	}

	public void setBusSysName(String busSysName) {
		this.busSysName = busSysName;
	}

	public String getBusUserName() {
		return busUserName;
	}

	public void setBusUserName(String busUserName) {
		this.busUserName = busUserName;
	}
}
