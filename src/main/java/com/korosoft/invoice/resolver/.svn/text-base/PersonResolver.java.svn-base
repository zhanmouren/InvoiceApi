package com.korosoft.invoice.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.korosoft.invoice.authority.annotation.StaffAttribute;
import com.korosoft.invoice.bean.SysUserBean;
import com.korosoft.invoice.service.SysUserService;
import com.korosoft.invoice.util.JwtUtils;

import io.jsonwebtoken.Claims;

public class PersonResolver implements HandlerMethodArgumentResolver{
	
	@Autowired
	private SysUserService sysUserService;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		StaffAttribute attr = parameter.getParameterAnnotation(StaffAttribute.class);
		return parameter.getParameterType().equals(SysUserBean.class) && attr != null;
	}

	@Override	
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		String token = request.getHeader("token");
		if(!JwtUtils.isExpired(token)) {
			Claims claim = JwtUtils.parseJWT(token);
			if(claim != null) {
				return sysUserService.getSysUserByLoginName(claim.get("loginName", String.class));
			}
		}
		return null;
	}
}
