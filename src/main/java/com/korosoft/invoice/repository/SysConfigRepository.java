package com.korosoft.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.korosoft.invoice.bean.SysConfigBean;

@Repository
public interface SysConfigRepository extends JpaRepository<SysConfigBean, Long>, JpaSpecificationExecutor<SysConfigBean>{

	/**
	 * 查询系统配置根据groupCode
	 * @param groupCode
	 * @return
	 */
	SysConfigBean findByGroupCode(Integer groupCode);
	
}
