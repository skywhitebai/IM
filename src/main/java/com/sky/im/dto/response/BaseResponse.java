package com.sky.im.dto.response;

import com.alibaba.fastjson.JSONObject;
import com.sky.im.common.constant.BaseCodeConstant;
import com.sky.im.common.enums.IBaseEnum;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 操作成功编码
	 */
	public static final String SUCCESS_CODE = BaseCodeConstant.SUCCESS_CODE;
	public static final String FAIL_CODE = BaseCodeConstant.FAIL_CODE;
	/**
	 * 200表示成功，其他自定义编码
	 */
	private String code;

	/**
	 * 信息
	 */
	private String message;

	/**
	 * 详细信息
	 */
	private String detailMessage;

	/**
	 * 响应其他数据
	 */
	private T data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		 return JSONObject.toJSON(this).toString();
	}

	public static BaseResponse success() {
		
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(BaseCodeConstant.SUCCESS_CODE);
		baseResponse.setMessage(BaseCodeConstant.msgMap
				.get(BaseCodeConstant.SUCCESS_CODE));
		return baseResponse;
	}

	public static BaseResponse success(String message, Object data) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(BaseCodeConstant.SUCCESS_CODE);
		baseResponse.setMessage(message);
		baseResponse.setData(data);
		return baseResponse;
	}

	public static BaseResponse successMessage(String message) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(BaseCodeConstant.SUCCESS_CODE);
		baseResponse.setMessage(message);
		return baseResponse;
	}

	public static BaseResponse successData(Object data) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(BaseCodeConstant.SUCCESS_CODE);
		baseResponse.setMessage(BaseCodeConstant.msgMap
				.get(BaseCodeConstant.SUCCESS_CODE));
		baseResponse.setData(data);
		return baseResponse;
	}

	public static BaseResponse fail() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(BaseCodeConstant.FAIL_CODE);
		baseResponse.setMessage(BaseCodeConstant.msgMap
				.get(BaseCodeConstant.FAIL_CODE));
		return baseResponse;
	}

	public static BaseResponse failMessage(String message) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(BaseCodeConstant.FAIL_CODE);
		baseResponse.setMessage(message);
		return baseResponse;
	}

	public static BaseResponse fail(String code, String message) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(code);
		baseResponse.setMessage(message);
		return baseResponse;
	}
	public static BaseResponse baseEnum(IBaseEnum baseEnum) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(baseEnum.getCode());
		baseResponse.setMessage(baseEnum.getLabel());
		return baseResponse;
	}
	public static BaseResponse baseEnum(IBaseEnum baseEnum,Object data) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(baseEnum.getCode());
		baseResponse.setMessage(baseEnum.getLabel());
		baseResponse.setData(data);
		return baseResponse;
	}
}
