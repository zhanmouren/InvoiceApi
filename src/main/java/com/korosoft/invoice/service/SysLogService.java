package com.korosoft.invoice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.korosoft.invoice.bean.SysLogBean;

public interface SysLogService {
	
	void save(SysLogBean bean);
	
	Page<SysLogBean> listSysLogPage(SysLogBean bean, int page, int pageSize);
	

}
