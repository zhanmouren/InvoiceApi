package com.korosoft.invoice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korosoft.invoice.authority.annotation.LogType;
import com.korosoft.invoice.authority.annotation.LoginToken;
import com.korosoft.invoice.authority.annotation.StaffAttribute;
import com.korosoft.invoice.authority.annotation.Validation;
import com.korosoft.invoice.bean.SysUserBean;
import com.korosoft.invoice.dto.InvoiceStatisticsDto;
import com.korosoft.invoice.service.Contans;
import com.korosoft.invoice.service.InvoiceStatisticsService;
import com.korosoft.invoice.service.SysConfigService;
import com.korosoft.invoice.service.SysLogService;
import com.korosoft.invoice.vo.ResponseData;

@RestController
public class InvoiceStatisticsController {

	
	private InvoiceStatisticsService statisticsService;
	
	@Autowired
	public InvoiceStatisticsController(InvoiceStatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}
	
	@LogType("统计信息")
	@GetMapping("/statistics")
	public ResponseData listStatistics(HttpServletRequest request,Integer page, Integer pageSize, @StaffAttribute(Contans.USER) SysUserBean user) {
		request.setAttribute(Contans.GROUP_CODE, user.getGroupCode());
		List<InvoiceStatisticsDto> p = statisticsService.statistics();
		return ResponseData.success(0,p.size(),p,"查询成功");		
	}

}
