package com.korosoft.invoice.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korosoft.invoice.authority.annotation.LoginToken;
import com.korosoft.invoice.authority.annotation.StaffAttribute;
import com.korosoft.invoice.bean.SysConfigBean;
import com.korosoft.invoice.bean.SysUserBean;
import com.korosoft.invoice.service.Contans;
import com.korosoft.invoice.service.SysConfigService;
import com.korosoft.invoice.vo.ResponseData;

@RestController
@RequestMapping("/config")
public class SysConfigController {
	
	private SysConfigService sysConfigService;
	
	@Autowired
	public SysConfigController(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}
	
	@LoginToken
	@GetMapping("/get")
	public ResponseData getSysConfigById(Long id, HttpServletRequest request, @StaffAttribute(Contans.USER) SysUserBean user) {
		if(id == null) {
			return ResponseData.faill("【id】不能为空");
		}
		request.setAttribute(Contans.GROUP_CODE, user.getGroupCode());
		SysConfigBean bean = sysConfigService.getSysConfigById(id);
		return ResponseData.success(bean, "查询成功");
	}
	
	@LoginToken
	@GetMapping("/list")
	public ResponseData listSysConfig(HttpServletRequest request, SysConfigBean bean, Integer page, Integer pageSize, @StaffAttribute(Contans.USER) SysUserBean user) {
		request.setAttribute(Contans.GROUP_CODE, user.getGroupCode());
		if(page == null || pageSize == null) {
			return ResponseData.faill("page 或者 pageSize 参数不能为空");
		}
		Page<SysConfigBean> p = sysConfigService.listSysConfigPage(bean, page, pageSize);
		return ResponseData.success(p.getNumber(), p.getTotalElements(), p.getContent(), "查询成功");
	}
	
	@LoginToken
	@PostMapping("/save")
	public ResponseData save(@Valid SysConfigBean bean, BindingResult result, HttpServletRequest request, @StaffAttribute(Contans.USER) SysUserBean user) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				return ResponseData.faill(error.getDefaultMessage());
			}
		}
		if(bean.getId() == null) {
			bean.setCreateName(user.getLoginName());
			bean.setCreateTime(new Date());
		}else {
			bean.setUpdateName(user.getLoginName());
			bean.setUpdateTime(new Date());
		}
		request.setAttribute(Contans.GROUP_CODE, user.getGroupCode());
		sysConfigService.save(bean);
		return ResponseData.success("保存成功");
	}
}
