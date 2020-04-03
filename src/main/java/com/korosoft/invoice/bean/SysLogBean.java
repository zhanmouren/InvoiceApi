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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="invoice_log")
public class SysLogBean
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public static final String TYPE_ACCESS = "1";
  public static final String TYPE_EXCEPTION = "2";

  @Id
  @Column(name="l_id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @Column(name="begintime")
  private Date beginDate;

  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @Column(name="endtime")
  private Date endDate;

  @Column(name="exception")
  private String exception;

  @Column(name="method")
  private String method;

  @Column(name="requestdata")
  private String requestData;

  @Column(name="remoteaddr")
  private String remoteAddr;

  @Column(name="requesturi")
  private String requestUri;
  
  @Column(name="requestname")
  private String requestName;

  @Column(name="type")
  private String type;

  @Column(name="useragent")
  private String userAgent;

  @Column(name="responsedata")
  private String responseData;

  @Column(name="groupcode")
  private Integer groupCode;

  @Column(name="groupname")
  private String groupName;

  @Column(name="create_time")
  private Date createTime;

  @Column(name="update_time")
  private Date updateTime;

  @Column(name="create_name")
  private String createName;

  @Column(name="update_name")
  private String updateName;
  

  public String getGroupName()
  {
    return this.groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getGroupCode() {
    return this.groupCode;
  }

  public void setGroupCode(Integer groupCode) {
    this.groupCode = groupCode;
  }

  public Date getBeginDate() {
    return this.beginDate;
  }

  public void setBeginDate(Date beginDate) {
    this.beginDate = beginDate;
  }

  public Date getEndDate() {
    return this.endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getException() {
    return this.exception;
  }

  public void setException(String exception) {
    this.exception = exception;
  }

  public String getMethod() {
    return this.method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getRequestData() {
    return this.requestData;
  }

  public void setRequestData(String requestData) {
    this.requestData = requestData;
  }

  public String getRemoteAddr() {
    return this.remoteAddr;
  }

  public void setRemoteAddr(String remoteAddr) {
    this.remoteAddr = remoteAddr;
  }

  public String getRequestUri() {
    return this.requestUri;
  }


public void setRequestUri(String requestUri) {
    this.requestUri = requestUri;
  }

public String getRequestName() {
	return requestName;
}

public void setRequestName(String requestName) {
	this.requestName = requestName;
}

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUserAgent() {
    return this.userAgent;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return this.updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getCreateName() {
    return this.createName;
  }

  public void setCreateName(String createName) {
    this.createName = createName;
  }

  public String getUpdateName() {
    return this.updateName;
  }

  public void setUpdateName(String updateName) {
    this.updateName = updateName;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public String getResponseData() {
    return this.responseData;
  }

  public void setResponseData(String responseData) {
    this.responseData = responseData;
  }


}