package com.korosoft.invoice.dto;

import java.util.List;

public class InvoiceInfoDto {

	
	/**单据批次号,表示每次交互的编号*/
	private String billBatchNo;
	
	/**销售单号*/
	private String billCode;
	
	/**单据日期：yyyy-MM-dd */
	private String billDate;
	
	/**单据日期：yyyy-MM-dd */
	private String busSysId;
	
	/**单据日期：yyyy-MM-dd */
	private String busSysName;
	
	/**业务系统用户名：E税云维护*/
	private String busUserName;
	
	/**业务系统用户密码：E税云维护*/
	private String busUserPwd;
	
	/**销方名称*/
	private String saleName;
	
	/**销方地址*/
	private String saleAddress;
	
	/**销方电话*/
	private String salePhone;
	
	/**销方开户银行*/
	private String saleBank;
	
	/**销方开户银行账号*/
	private String saleBankAccount;
	
	/**销方纳税人信用代码*/
	private String saleCreditCode;
	
	/**购方企业类型*/
	private String creditType; 
	
	/**购方纳税人信用代码*/
	private String custCreditCode;
	
	/**购方地址*/
	private String custAddress;
	
	/**购方名称*/
	private String custName;
	
	/**购方电话*/
	private String custPhone;
	
	/**购方手机*/
	private String custMobile;
	
	/**购方邮箱*/
	private String custEmail;
	
	/**购方开户银行*/
	private String custBank;
	
	/**购方银行账号*/
	private String custBankAccount;
	
	/**发票种类,0(专票);2(普票);;51(电子票)*/
	private String invType;
	
	/**发票代码*/
	private String invoiceCode;
	
	/**需要加密，发票号码*/
	private String invoiceNumber;
	
	/**发票性质：0(正数)；1(负数)*/
	private String invoiceNature;
	
	/**开票机构编码：E税云维护*/
	private String invoiceOrgCode;
	
	/**发票种类：51(电子票)*/
	private String invoiceType;
	
	/**收款人*/
	private String payee;
	
	/**复核人*/
	private String reviewer;
	
	/**复核人*/
	private String openPeople;
	
	/**是否含税,0(否);1(是)*/
	private String isTax;
	
	/**开票点编号*/
	private String ukeyCode;
	
	/**开票机号*/
	private String diskCode;
	
	/**待开标识，是否自动生成待开发票*/
	private String invoiceAuto;
	
	/**备注*/
	private String remark;
	
	/**旧的发票代码*/
	private String oldBillCode;
	
	/**旧的发票批次号*/
	private String oldBillBatch;
	
	/**销售单明细*/
	private List<AmountInfoDto> billDetailApiList;
	
	public String getOldBillCode() {
		return oldBillCode;
	}

	public void setOldBillCode(String oldBillCode) {
		this.oldBillCode = oldBillCode;
	}

	public String getOldBillBatch() {
		return oldBillBatch;
	}

	public void setOldBillBatch(String oldBillBatch) {
		this.oldBillBatch = oldBillBatch;
	}


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

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getBusSysId() {
		return busSysId;
	}

	public void setBusSysId(String busSysId) {
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

	public String getCreditType() {
		return creditType;
	}

	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}

	public String getCustCreditCode() {
		return custCreditCode;
	}

	public void setCustCreditCode(String custCreditCode) {
		this.custCreditCode = custCreditCode;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustBank() {
		return custBank;
	}

	public void setCustBank(String custBank) {
		this.custBank = custBank;
	}

	public String getCustBankAccount() {
		return custBankAccount;
	}

	public void setCustBankAccount(String custBankAccount) {
		this.custBankAccount = custBankAccount;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

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

	public String getInvoiceNature() {
		return invoiceNature;
	}

	public void setInvoiceNature(String invoiceNature) {
		this.invoiceNature = invoiceNature;
	}

	public String getInvoiceOrgCode() {
		return invoiceOrgCode;
	}

	public void setInvoiceOrgCode(String invoiceOrgCode) {
		this.invoiceOrgCode = invoiceOrgCode;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getOpenPeople() {
		return openPeople;
	}

	public void setOpenPeople(String openPeople) {
		this.openPeople = openPeople;
	}

	public String getIsTax() {
		return isTax;
	}

	public void setIsTax(String isTax) {
		this.isTax = isTax;
	}

	public String getUkeyCode() {
		return ukeyCode;
	}

	public void setUkeyCode(String ukeyCode) {
		this.ukeyCode = ukeyCode;
	}

	public String getDiskCode() {
		return diskCode;
	}

	public void setDiskCode(String diskCode) {
		this.diskCode = diskCode;
	}

	public String getInvoiceAuto() {
		return invoiceAuto;
	}

	public void setInvoiceAuto(String invoiceAuto) {
		this.invoiceAuto = invoiceAuto;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<AmountInfoDto> getBillDetailApiList() {
		return billDetailApiList;
	}

	public void setBillDetailApiList(List<AmountInfoDto> billDetailApiList) {
		this.billDetailApiList = billDetailApiList;
	}

}
