package com.korosoft.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.korosoft.invoice.ApplicationConfig;
import com.korosoft.invoice.bean.SysUserBean;
import com.korosoft.invoice.repository.SysUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class SysUserRepositoryTest {
	
	@Autowired
	private SysUserRepository sysUserRepository;
	
	@Test
	public void getOne() {
		SysUserBean sysUser = sysUserRepository.getOne(1L);
		Assert.assertNotNull(sysUser);
	}
	
	@Test
	public void findAll() {
		List<SysUserBean> data = sysUserRepository.findAll();
		Assert.assertNotNull(data);
	}
}
