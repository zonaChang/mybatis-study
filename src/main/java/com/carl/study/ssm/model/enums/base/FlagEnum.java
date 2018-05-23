package com.carl.study.ssm.model.enums.base;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月23日下午10:28:10
 */
public interface FlagEnum<E extends Enum<E>> {

	int getFlagValue();
}
