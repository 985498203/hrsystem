package com.hxzy.hrsystem.util;

import java.util.HashMap;
import java.util.Map;

/**
 * json 封装
 */
public class JsonData {
	private boolean ret;// 处理结果
	private String msg;// 处理消息
	private Object data;// 返回的数据
	private Map<String, Object> extend = new HashMap<String, Object>();// 用户要返回浏览器的数据

	public JsonData(boolean ret) {
		this.ret = ret;
	}

	/**
	 * 处理成功返回消息和数据
	 * 
	 * @param object
	 * @param msg
	 * @return
	 */
	public static JsonData success(Object object, String msg) {
		JsonData jsonData = new JsonData(true);
		jsonData.data = object;
		jsonData.msg = msg;
		return jsonData;
	}

	public JsonData add(String key, Object value) {
		this.extend.put(key, value);
		return this;

	}

	/**
	 * 处理成功
	 * 
	 * @param object
	 * @param msg
	 * @return
	 */
	public static JsonData success() {
		return new JsonData(true);
	}

	/**
	 * 处理成功
	 * 
	 * @param object
	 * @param msg
	 * @return
	 */
	public static JsonData successSendMsg(String msg) {
		JsonData jsonData = new JsonData(true);
		jsonData.msg = msg;
		return jsonData;
	}

	/**
	 * 处理成功返回数据
	 * 
	 * @param object
	 * @return
	 */
	public static JsonData success(Object object) {
		JsonData jsonData = new JsonData(true);
		jsonData.data = object;
		return jsonData;
	}

	/**
	 * 处理失败返回错误信息
	 * 
	 * @param msg
	 * @return
	 */
	public static JsonData fail(String msg) {
		JsonData jsonData = new JsonData(false);
		jsonData.msg = msg;
		return jsonData;
	}

	/**
	 * 处理失败
	 * 
	 * @param msg
	 * @return
	 */
	public static JsonData fail() {
		JsonData jsonData = new JsonData(false);
		return jsonData;
	}

	public boolean isRet() {
		return ret;
	}

	public void setRet(boolean ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
