package com.hxzy.hrsystem.util;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.TypeReference;

public class JsonMapper {
	private static ObjectMapper objectMapper = new ObjectMapper();
	static {
		// 排除为空的字段；
		objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
	}

	/**
	 * 对象转为json字符串
	 * 
	 * @param src
	 * @param     <T>
	 * @return
	 */
	public static <T> String objToString(T src) {
		if (src == null) {
			return null;
		}
		try {
			return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	/**
     * json字符串转为对象
     * @param src
     * @param typeReference
     * @param <T>
     * @return
     */
    public static <T> T stringToObj(String src, TypeReference<T> typeReference) {
        if (src == null || typeReference == null) {
            return null;
        }
        try {
            return (T) (typeReference.getType().equals(String.class) ? src : objectMapper.readValue(src, typeReference));
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }

}
