package com.fkb.utils;

import java.util.List;

import com.fkb.domain.Box;

public class ResultBean {
	
	private String status ;
	private String msg;
	private String type;
	private List<Box> data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Box> getData() {
		return data;
	}
	public void setData(List<Box> data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
