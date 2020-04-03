package com.korosoft.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korosoft.invoice.bean.SysUserBean;
import com.korosoft.invoice.service.SysUserService;

@RestController
@RequestMapping("/sysuser")
public class SysUserController {
	
	private SysUserService sysUserService;
	
	@Autowired
	public SysUserController(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	@GetMapping("/list")
	public List<SysUserBean> listSysUser(){
		return sysUserService.listSysUser();
	}
	
	@GetMapping("/get/{id}")
	public SysUserBean getSysUserById(@PathVariable("id") Long id){
		return sysUserService.getSysUserById(id);
	}
}
