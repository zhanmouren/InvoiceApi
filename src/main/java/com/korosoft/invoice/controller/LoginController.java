package com.korosoft.invoice.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korosoft.invoice.bean.SysUserBean;
import com.korosoft.invoice.service.Contans;
import com.korosoft.invoice.service.SysUserService;
import com.korosoft.invoice.util.JwtUtils;
import com.korosoft.invoice.vo.ResponseData;

@RestController
public class LoginController {
	
	private SysUserService sysUserService;
	
	@Autowired
	public LoginController (SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	@PostMapping("/login")
	public ResponseData login(HttpServletRequest request, HttpServletResponse response) {
		String loginName = request.getParameter("loginName");
		if(StringUtils.isBlank(loginName)) {
			return ResponseData.faill("用户名或密码不能为空!");
		}
		String password = request.getParameter("password");
		if(StringUtils.isBlank(password)) {
			return ResponseData.faill("用户名或密码不能为空!");
		}
		SysUserBean user = sysUserService.getSysUserByLoginName(loginName);
		if(user == null) {
			return ResponseData.faill("用户名或密码错误!");
		}
		if(!Objects.equals(user.getPassword(), password)) {
			return ResponseData.faill("用户名或密码错误!");
		}
		request.setAttribute(Contans.GROUP_CODE, user.getGroupCode());
		String token = JwtUtils.createJWT(Contans.EXPIRED_MINUTE, user);
		return ResponseData.success(token, "登录成功！");
	}
}
