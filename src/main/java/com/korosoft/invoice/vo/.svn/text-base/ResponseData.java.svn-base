package com.korosoft.invoice.vo;

public class ResponseData {
	
	/**
	 * 
	 */
	
	public static final int SUCCESS_CODE = 0;
	
	public static final int FAIL_CODE = -1;

	private int code;
	
	private String message;

	private Object data;
	
	private int page;
	
	private long total;
	
	public final static ResponseData success(String message) {
		ResponseData data = new ResponseData();
		data.setCode(ResponseData.SUCCESS_CODE);
		data.setMessage(message);
		return data;
	}
	
	public final static ResponseData success(Object object, String message) {
		ResponseData data = new ResponseData();
		data.setCode(ResponseData.SUCCESS_CODE);
		data.setMessage(message);
		data.setData(object);
		return data;
	}
	
	public final static ResponseData success(int page, long count, Object object, String message) {
		ResponseData data = new ResponseData();
		data.setCode(ResponseData.SUCCESS_CODE);
		data.setMessage(message);
		data.setData(object);
		data.setPage(page);
		data.setTotal(count);
		return data;
	}
	
	public final static ResponseData faill(String message) {
		ResponseData data = new ResponseData();
		data.setCode(ResponseData.FAIL_CODE);
		data.setMessage(message);
		return data;
	}
	
	public final static ResponseData faill(Object object, String message) {
		ResponseData data = new ResponseData();
		data.setCode(ResponseData.FAIL_CODE);
		data.setMessage(message);
		data.setData(object);
		return data;
	}
	
	public final static ResponseData faill(int code, String message) {
		ResponseData data = new ResponseData();
		data.setCode(code);
		data.setMessage(message);
		return data;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getCode() {
		return code;
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
