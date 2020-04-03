package com.korosoft.invoice.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSONObject;

public class RequestUtils {

	
	public static String getRemoteAddr(HttpServletRequest request) {
	    String ip = request.getHeader("x-forwarded-for");
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	    if (ip.contains(",")) {
	        return ip.split(",")[0];
	    } else {
	        return ip;
	    }
	}
	
	public static String parameterToString(HttpServletRequest request) throws IOException {
		JSONObject json = new JSONObject();
		String contentType = request.getHeader("Content-Type");
		if(Objects.equals("application/json", contentType)) {
			InputStream input = request.getInputStream();
			String data = IOUtils.toString(input, "UTF-8");
			json = JSONObject.parseObject(data);
		} else { //application/x-www-form-urlencoded
			Enumeration<String> enumeration = request.getParameterNames();
			while(enumeration.hasMoreElements()) {
				String key = enumeration.nextElement();
				json.put(key, Objects.toString(request.getParameter(key), ""));
			}
		}
		return json.toJSONString();
	}
}
