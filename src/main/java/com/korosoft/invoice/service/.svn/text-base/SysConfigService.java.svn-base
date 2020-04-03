package com.korosoft.invoice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.korosoft.invoice.bean.SysConfigBean;

public interface SysConfigService {
	
	SysConfigBean getSysConfigById(long id);
	
	SysConfigBean getSysConfigByGroupCode(int groupCode);

	void save(SysConfigBean bean);
	
	Page<SysConfigBean> listSysConfigPage(SysConfigBean bean, int page, int pageSize);
	
	List<SysConfigBean> listAllSysConfig();
	
	void deleteById(long id);

}
