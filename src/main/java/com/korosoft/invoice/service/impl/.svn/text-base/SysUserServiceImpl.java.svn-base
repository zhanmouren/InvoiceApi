package com.korosoft.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korosoft.invoice.bean.SysUserBean;
import com.korosoft.invoice.repository.SysUserRepository;
import com.korosoft.invoice.service.Contans;
import com.korosoft.invoice.service.SysUserService;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService{
	
	private SysUserRepository sysUserRepository;
	
	@Autowired
	public SysUserServiceImpl(SysUserRepository sysUserRepository) {
		this.sysUserRepository = sysUserRepository;
	}

	@Override
	public SysUserBean getSysUserById(long id) {
		return sysUserRepository.getOne(id);
	}

	@Override
	public List<SysUserBean> listSysUser() {
		return sysUserRepository.findAll();
	}

	@Override
	@Cacheable(value = Contans.CACHE_NAME, key = "'user_'+#loginName")
	public SysUserBean getSysUserByLoginName(String loginName) {
		return sysUserRepository.findByLoginName(loginName);
	}
}
