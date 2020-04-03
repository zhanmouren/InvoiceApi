package com.korosoft.invoice.authority;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.korosoft.invoice.authority.annotation.LoginToken;
import com.korosoft.invoice.service.Contans;
import com.korosoft.invoice.util.JwtUtils;
import com.korosoft.invoice.vo.ResponseData;

/**
 * 登录权限验证
 * @author 59532
 *
 */
@Aspect
@Component
public class LoginAuthorizeAspect {
	
	@Pointcut("@annotation(com.korosoft.invoice.authority.annotation.LoginToken)")
	public void cut() {
		
	}

	@Around("cut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		MethodSignature sig = (MethodSignature) point.getSignature();
		Method method = sig.getMethod();
		LoginToken methodAnnotation = method.getAnnotation(LoginToken.class);
		if(methodAnnotation != null) {
			ResponseData data = ResponseData.faill(1001, "未登录");
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String token = request.getHeader(Contans.TOKEN);
			if(token == null) {
				return data;
			}
			boolean isExpired = JwtUtils.isExpired(token);
			if(isExpired) {
				return data;
			}
		}
		return point.proceed();
	}
}
