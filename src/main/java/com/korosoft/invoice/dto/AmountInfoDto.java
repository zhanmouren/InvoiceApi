package com.korosoft.invoice.dto;

public class AmountInfoDto {

	/**是否享受优惠政策,0(否);1(是)*/
	private String isPrivilege;
	
	/**优惠政策说明*/
	private String privilegeType;
	
	/**是否含税,0(否);1(是)*/
	private String isTax;
	
	/**行性质：0(商品行);1(折扣行)*/
	private String lineNature;
	
	/**商品名称*/
	private String matName;
	
	/**金额*/
	private double money;
	
	/**税收编码：税收合并编码；商品行必填*/
	private String revenueCode;
	
	/**税收版本号*/
	private String revenueVersion;
	
	/**数量*/
	private double quantity;
	
	/**单价*/
	private double priceMoney;
	
	/**税率。如果是折扣行，允许为空；*/
	private String taxRate;
	
	/**税额*/
	private double taxAmount;
	
	/**零税率标志*/
	private String zeroTax;
	
	/**单位*/
	private String unit;
	
	/**折扣行标志*/
	private String discountNo;
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getZeroTax() {
		return zeroTax;
	}

	public void setZeroTax(String zeroTax) {
		this.zeroTax = zeroTax;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPriceMoney() {
		return priceMoney;
	}

	public void setPriceMoney(double priceMoney) {
		this.priceMoney = priceMoney;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getIsPrivilege() {
		return isPrivilege;
	}

	public void setIsPrivilege(String isPrivilege) {
		this.isPrivilege = isPrivilege;
	}

	public String getIsTax() {
		return isTax;
	}

	public void setIsTax(String isTax) {
		this.isTax = isTax;
	}

	public String getLineNature() {
		return lineNature;
	}

	public void setLineNature(String lineNature) {
		this.lineNature = lineNature;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public String getRevenueCode() {
		return revenueCode;
	}

	public void setRevenueCode(String revenueCode) {
		this.revenueCode = revenueCode;
	}

	public String getRevenueVersion() {
		return revenueVersion;
	}

	public void setRevenueVersion(String revenueVersion) {
		this.revenueVersion = revenueVersion;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public String getDiscountNo() {
		return discountNo;
	}

	public void setDiscountNo(String discountNo) {
		this.discountNo = discountNo;
	}

	public String getPrivilegeType() {
		return privilegeType;
	}

	public void setPrivilegeType(String privilegeType) {
		this.privilegeType = privilegeType;
	}
}
