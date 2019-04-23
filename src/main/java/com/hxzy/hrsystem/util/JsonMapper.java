package com.hxzy.hrsystem.util;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;

import com.hxzy.hrsystem.entity.User;

/**
 * json转换
 */
public class JsonMapper {

	private static ObjectMapper objectMapper = new ObjectMapper();
	static {
		// config
		objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
		objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
	}

	/**
	 * 对象转为json字符串
	 * 
	 * @param src
	 * @param     <T>
	 * @return
	 */
	public static <T> String obj2String(T src) {
		if (null == src) {
			return null;
		}
		try {
			return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * json字符串转为对象
	 * 
	 * @param src
	 * @param typeReference
	 * @param               <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T string2Obj(String src, TypeReference<T> typeReference) {
		if (null == src || null == typeReference) {
			return null;
		}
		try {
			return (T) (typeReference.getType().equals(String.class) ? src
					: objectMapper.readValue(src, typeReference));
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("zhang");
		user.setPassword("123");
		User user2 = new User();
		user2.setUsername("li");
		user2.setPassword("123");

		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user2);

		System.out.println(obj2String(list));

	}
}
