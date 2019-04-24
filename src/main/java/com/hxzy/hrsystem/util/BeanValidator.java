package com.hxzy.hrsystem.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class BeanValidator {
	/**
	 * 校验工厂
	 */
	private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

	/**
	 * Map<字段，错误信息>
	 * 
	 * @param t
	 * @param groups
	 * @return
	 */
	public static <T> Map<String, String> validate(T t, Class... groups) {
		Validator validator = validatorFactory.getValidator();
		Set validateResult = validator.validate(t, groups);// 校验 获得的Set<ConstraintViolation>,约束违反的set集合
		if (validateResult.isEmpty()) {
			return Collections.emptyMap();
		} else {
			LinkedHashMap errors = Maps.newLinkedHashMap();
			Iterator iterator = validateResult.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation violation = (ConstraintViolation) iterator.next();
				errors.put(violation.getPropertyPath().toString(), violation.getMessage());// 封装结果集 （属性值-错误信息)
			}
			return errors;
		}
	}

	// 对一个集合类型进行遍历校验，上面的validate方法，不能处理集合类型
	public static Map<String, String> validateList(Collection<?> collection) {
		Preconditions.checkNotNull(collection);// 判断Collection是否为空
		Iterator iterator = collection.iterator();// 遍历集合
		Map errors;
		do {
			if (!iterator.hasNext()) {
				return Collections.emptyMap();
			}
			Object object = iterator.next();
			errors = validate(object, new Class[0]);
		} while (errors.isEmpty());// 只要集合内有一个字段错误，那么直接返回，不用考虑剩余元素

		return errors;
	}

	// 通用方法，至少传入一个Object参数，这个方法还是有问题，如果first为集合就BeanValidator.validateObject(testVo,testVo,testVo);
	public static Map<String, String> validateObject(Object first, Object... objects) {
		if (objects != null && objects.length > 0) {
			return validateList(Lists.asList(first, objects));
		} else if (first instanceof Collection) {
			return validateList((Collection) first);
		} else {
			return validate(first, new Class[0]);// 这个Class[] x = new Class[0];x里面没有东西
		}
	}

}
