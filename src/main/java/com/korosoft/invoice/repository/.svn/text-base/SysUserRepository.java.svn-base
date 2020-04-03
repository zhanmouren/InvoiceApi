package com.korosoft.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korosoft.invoice.bean.SysUserBean;

@Repository
public interface SysUserRepository extends JpaRepository<SysUserBean, Long>{
	
	SysUserBean findByLoginName(String loginName);

}
