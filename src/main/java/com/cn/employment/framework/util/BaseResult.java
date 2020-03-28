package com.cn.employment.framework.util;

import java.io.Serializable;

/**
 * 封装返回结果
 * @author msi-cn
 *
 * @param <T>
 */
public class BaseResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean success;
	private T data;
	private String errMsg;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
