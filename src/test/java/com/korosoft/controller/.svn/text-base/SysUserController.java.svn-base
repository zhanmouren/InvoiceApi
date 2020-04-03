package com.korosoft.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.korosoft.invoice.ApplicationConfig;
import com.korosoft.invoice.bean.SysUserBean;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SysUserController {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void listSysUser() {
		restTemplate.getForObject("/sysuser/list", String.class);
	}
	
	@Test
	public void getSysUser() {
		SysUserBean data = restTemplate.getForObject("/sysuser/get/1", SysUserBean.class);
		Assert.assertNotNull(data);
	}
	
}
