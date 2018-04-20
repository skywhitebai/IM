package com.sky.oms.common.enums;

public enum LoginEnum implements IBaseEnum{
	
	LOGIN_ACCOUNT_ERRO("01001", "用户名或密码错误"),
	LOGIN_DISABLE("401", "未登录或登录超时,请重新登录");
	
	private LoginEnum(String code, String label) {
		this.code = code;
		this.label = label;
	}

	private String code;
	
	private String label;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
