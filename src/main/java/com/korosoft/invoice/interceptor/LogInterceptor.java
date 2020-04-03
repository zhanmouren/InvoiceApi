package com.korosoft.invoice.interceptor;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.korosoft.invoice.authority.annotation.LogType;
import com.korosoft.invoice.bean.SysLogBean;
import com.korosoft.invoice.service.Contans;
import com.korosoft.invoice.service.SysLogService;
import com.korosoft.invoice.util.RequestUtils;

public class LogInterceptor implements HandlerInterceptor{
	
	@Autowired
	private SysLogService sysLogService;
	
	private ExecutorService service = Executors.newCachedThreadPool();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		SysLogBean log = new SysLogBean();
		log.setBeginDate(new Date());
		request.setAttribute("_log", log);
		log.setRequestData(RequestUtils.parameterToString(request));
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		if(request.getAttribute(Contans.GROUP_CODE) == null) {
			return;
		}
		SysLogBean log = (SysLogBean) request.getAttribute("_log");
		ex = (Exception) request.getAttribute(Contans.ERROR);
		log.setType(ex == null ? SysLogBean.TYPE_ACCESS : SysLogBean.TYPE_EXCEPTION);
		if(ex != null) {
			log.setException(ex.getMessage());
		}
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		LogType logType = handlerMethod.getMethodAnnotation(LogType.class);
		if(logType != null) {
			log.setRequestName(logType.value());
		}
		log.setGroupCode((int) request.getAttribute(Contans.GROUP_CODE));
		log.setRemoteAddr(RequestUtils.getRemoteAddr(request));
		log.setUserAgent(request.getHeader("user-agent"));
		log.setRequestUri(request.getRequestURI());
		log.setMethod(request.getMethod());
		log.setEndDate(new Date());
		service.execute(() -> sysLogService.save(log));
	}
}
