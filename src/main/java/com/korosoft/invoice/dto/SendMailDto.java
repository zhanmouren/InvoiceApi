package com.korosoft.invoice.dto;

public class SendMailDto {
	private String strHost;
	private String strFrom;
	private String strEmailUserName;
	private String strEmailPassword;
	private String EmailTitle;
	public String getStrHost() {
		return strHost;
	}
	public void setStrHost(String strHost) {
		this.strHost = strHost;
	}
	public String getStrFrom() {
		return strFrom;
	}
	public void setStrFrom(String strFrom) {
		this.strFrom = strFrom;
	}
	public String getStrEmailUserName() {
		return strEmailUserName;
	}
	public void setStrEmailUserName(String strEmailUserName) {
		this.strEmailUserName = strEmailUserName;
	}
	public String getStrEmailPassword() {
		return strEmailPassword;
	}
	public void setStrEmailPassword(String strEmailPassword) {
		this.strEmailPassword = strEmailPassword;
	}
	public String getEmailTitle() {
		return EmailTitle;
	}
	public void setEmailTitle(String emailTitle) {
		EmailTitle = emailTitle;
	}
	

}
