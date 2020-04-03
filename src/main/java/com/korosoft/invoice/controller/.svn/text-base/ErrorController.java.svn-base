package com.korosoft.invoice.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.korosoft.invoice.service.Contans;
import com.korosoft.invoice.vo.ResponseData;

@ControllerAdvice
public class ErrorController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);
	
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
	public ResponseData error(Exception ex, HttpServletRequest request) {
    	request.setAttribute(Contans.ERROR, ex);
    	LOGGER.error("服务器内部错误：{}", ex);
		return ResponseData.faill("服务器内部错误");
	}
}
