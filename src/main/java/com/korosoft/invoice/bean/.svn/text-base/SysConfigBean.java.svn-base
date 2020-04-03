package com.korosoft.invoice.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "invoice_config")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class SysConfigBean extends BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**主键*/
	@Id
	@Column(name = "c_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**E税云系统编号*/
	@Column(name = "BUSSYSID")
	@NotNull(message = "字段【busSysId】不能为空")
	private Integer busSysId;
	
	/**E税云系统名称*/
	@Column(name = "BUSSYSNAME")
	@NotEmpty(message = "字段【busSysName】不能为空")
	private String busSysName;
	
	/**E税云系统用户名*/
	@Column(name = "BUSUSERNAME")
	@NotEmpty(message = "字段【busUserName】不能为空")
	private String busUserName;
	
	/**E税云系统用户密码*/
	@Column(name = "BUSUSERPWD")
	@NotEmpty(message = "字段【busUserPwd】不能为空")
	private String busUserPwd;
	
	/**开票机构编码*/
	@Column(name = "INVOICEORGCODE")
	@NotEmpty(message = "字段【invoiceOrgCode】不能为空")
	private String invoiceOrgCode;
	
	/**水司编号*/
	@Column(name = "GROUPCODE")
	@NotNull(message = "字段【groupCode】不能为空")
	private Integer groupCode;
	
	/**水司名称*/
	@Column(name = "GROUPNAME")
	private String groupName;
	
	/**调用渠道*/
	@Column(name = "CHANNEL")
	private String channel;
	
	/**回调地址*/
	@Column(name = "BACKURL")
	@NotEmpty(message = "字段【backUrl】不能为空")
	private String backUrl;
	
	/**回调密钥*/
	@Column(name = "BACKPASSWORD")
	@NotEmpty(message = "字段【backPassword】不能为空")
	private String backPassword;
	
	/**销方名称*/
	@Column(name = "SALENAME")
	@NotEmpty(message = "字段【saleName】不能为空")
	private String saleName;
	
	/**销方地址*/
	@Column(name = "SALEADDRESS")
	@NotEmpty(message = "字段【saleAddress】不能为空")
	private String saleAddress;
	
	/**销方电话*/
	@Column(name = "SALEPHONE")
	@NotEmpty(message = "字段【salePhone】不能为空")
	private String salePhone;
	
	/**销方开户银行*/
	@Column(name = "SALEBANK")
	@NotEmpty(message = "字段【saleBank】不能为空")
	private String saleBank;
	
	/**销方开户银行账号*/
	@Column(name = "BANKACCOUNT")
	@NotEmpty(message = "字段【BankAccount】不能为空")
	private String saleBankAccount;
	
	/**销方纳税人信用代码*/
	@Column(name = "SALECREDITCODE")
	@NotEmpty(message = "字段【saleCreditCode】不能为空")
	private String saleCreditCode;
	
	/**待开标识*/
	@Column(name = "INVOICEAUTO")
	private String invoiceAuto; 
	
	/**是否含税*/
	@Column(name = "ISTAX")
	private String isTax; 
	
	/**户数*/
	@Column(name = "WATCH_NUM")
	private Integer watchNum; 
	
	@Column(name = "create_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	@Column(name = "update_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	@Column(name = "create_name")
	private String createName;
	
	@Column(name = "update_name")
	private String updateName;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getBusUserPwd() {
		return busUserPwd;
	}

	public void setBusUserPwd(String busUserPwd) {
		this.busUserPwd = busUserPwd;
	}

	public String getInvoiceOrgCode() {
		return invoiceOrgCode;
	}

	public void setInvoiceOrgCode(String invoiceOrgCode) {
		this.invoiceOrgCode = invoiceOrgCode;
	}

	public Integer getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(Integer groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	public String getBackPassword() {
		return backPassword;
	}

	public void setBackPassword(String backPassword) {
		this.backPassword = backPassword;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public String getSaleAddress() {
		return saleAddress;
	}

	public void setSaleAddress(String saleAddress) {
		this.saleAddress = saleAddress;
	}

	public String getSalePhone() {
		return salePhone;
	}

	public void setSalePhone(String salePhone) {
		this.salePhone = salePhone;
	}

	public String getSaleBank() {
		return saleBank;
	}

	public void setSaleBank(String saleBank) {
		this.saleBank = saleBank;
	}

	public String getSaleBankAccount() {
		return saleBankAccount;
	}

	public void setSaleBankAccount(String saleBankAccount) {
		this.saleBankAccount = saleBankAccount;
	}

	public String getSaleCreditCode() {
		return saleCreditCode;
	}

	public void setSaleCreditCode(String saleCreditCode) {
		this.saleCreditCode = saleCreditCode;
	}

	public String getInvoiceAuto() {
		return invoiceAuto;
	}

	public void setInvoiceAuto(String invoiceAuto) {
		this.invoiceAuto = invoiceAuto;
	}

	public String getIsTax() {
		return isTax;
	}

	public void setIsTax(String isTax) {
		this.isTax = isTax;
	}

	public Integer getWatchNum() {
		return watchNum;
	}

	public void setWatchNum(Integer watchNum) {
		this.watchNum = watchNum;
	}

}
