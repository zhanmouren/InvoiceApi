package com.korosoft.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.korosoft.invoice.ApplicationConfig;
import com.korosoft.invoice.bean.SysUserBean;
import com.korosoft.invoice.service.SysUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
@Transactional
public class SysUserServiceTest {
	
	@Autowired
	private SysUserService sysUserService;
	
	@Test
	public void listSysUser() {
		List<SysUserBean> data = sysUserService.listSysUser();
		Assert.assertNotNull(data);
	}
	
	@Test
	public void getSysUserById() {
		SysUserBean data = sysUserService.getSysUserById(1L);
		Assert.assertNotNull(data);
	}

}
