package com.josephocallaghan.lottoapp.config;

import java.util.HashMap;
import java.util.Map;

public class AjaxResponse {
	
	private Boolean success;
	private Integer statusCode; 
	private String header;
	private String message;
	private String errTrace;
	private Map<String, Object> data = new HashMap<String, Object>();
	private Object view = "error";
	 
	public AjaxResponse() {
		header = "info";
		message = "success";
		success = true;
		statusCode = 200;
	}
	
	public AjaxResponse(String msg) {
		header = "info";
		message = msg;
		success = true;
		statusCode = 200;
	}
	 
	public Boolean getSuccess() {
		return success;
	}
	 
	public void setSuccess(Boolean success) {
		this.success = success;
		if(success)
			this.statusCode = 200;
	}
	 
	 
	public void setSuccess(Boolean success, Integer statusCode) {
		this.success = success;
		this.statusCode = statusCode;
	}
	 



	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getView() {
		return view;
	}

	public void setView(Object view) {
		this.view = view;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public String getErrTrace() {
		return errTrace;
	}

	public void setErrTrace(String errTrace) {
		this.errTrace = errTrace;
	}
	
}
