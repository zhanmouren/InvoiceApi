package com.korosoft.invoice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korosoft.invoice.authority.annotation.LogType;
import com.korosoft.invoice.authority.annotation.LoginToken;
import com.korosoft.invoice.authority.annotation.StaffAttribute;
import com.korosoft.invoice.bean.SysLogBean;
import com.korosoft.invoice.bean.SysUserBean;
import com.korosoft.invoice.dto.InvoiceStatisticsDto;
import com.korosoft.invoice.service.Contans;
import com.korosoft.invoice.service.ElectronicInvoiceService;
import com.korosoft.invoice.service.InvoiceStatisticsService;
import com.korosoft.invoice.service.SysLogService;
import com.korosoft.invoice.vo.ResponseData;

@RestController
@RequestMapping("/log")
public class SysLogCntroller {
	
	private SysLogService sysLogService;
	
	
	@Autowired
	public SysLogCntroller(SysLogService sysLogService) {
		this.sysLogService = sysLogService;
	}

	
	
	@LogType("日志查询")
	@LoginToken
	@GetMapping("/list")
	public ResponseData listSysLog(HttpServletRequest request, SysLogBean bean, Integer page, Integer pageSize, @StaffAttribute(Contans.USER) SysUserBean user) {
		if(page == null || pageSize == null) {
			return ResponseData.success("page 或者 pageSize 参数不能为空");
		}
		request.setAttribute(Contans.GROUP_CODE, user.getGroupCode());
		Page<SysLogBean> p = sysLogService.listSysLogPage(bean, page, pageSize);
		return ResponseData.success(p.getNumber(), p.getTotalElements(), p.getContent(), "查询成功");
	}
	
/*	@LogType("统计信息")
	@GetMapping("/statistics")
	public ResponseData statistics() {
		//request.setAttribute(Contans.GROUP_CODE, user.getGroupCode());
		System.out.println("123456++++");
		List<InvoiceStatisticsDto> p = statisticsService.statistics();
		return ResponseData.success( p, "查询成功");
	}*/
	
}
