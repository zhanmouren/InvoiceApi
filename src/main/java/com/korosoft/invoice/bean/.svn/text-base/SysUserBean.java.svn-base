package com.korosoft.invoice.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 系统用户
 * @author 59532
 *
 */
@Entity
@Table(name = "invoice_user")
public class SysUserBean extends BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "u_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sys_user")
	@SequenceGenerator(name="seq_sys_user", sequenceName="seq_sys_user", allocationSize = 1)
	private Long id;
	
	@Column(name = "loginname")
	private String loginName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "groupcode")
	private Integer groupCode;
	
	@Column(name = "groupname")
	private String groupName;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
