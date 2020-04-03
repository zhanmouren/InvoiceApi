package com.korosoft.invoice.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestWrapperFilter implements Filter{
	
	private static final Logger LOGG = LoggerFactory.getLogger(RequestWrapperFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest)request;
			if(!Objects.equals("application/json", httpServletRequest.getHeader("Content-Type"))) {
				chain.doFilter(request, response); 
				return;
			}
	        ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);  
	        chain.doFilter(requestWrapper, response);
		}else {
			 chain.doFilter(request, response);
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGG.info("RequestWrapperFilter Filter init ....");
	}
	
	@Override
	public void destroy() {
		LOGG.info("RequestWrapperFilter Filter destroy ....");
	}
}
