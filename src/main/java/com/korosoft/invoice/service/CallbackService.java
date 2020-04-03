package com.korosoft.invoice.service;

import com.alibaba.fastjson.JSONObject;
import com.korosoft.invoice.vo.ResponseData;

public interface CallbackService {

	ResponseData callback(int groupCode, JSONObject data);
	
}
