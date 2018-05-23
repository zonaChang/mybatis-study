package com.carl.study.ssm.model.enums;

import com.carl.study.ssm.model.enums.base.FlagEnum;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月16日下午9:59:19
 */
public enum SexEnum implements FlagEnum<SexEnum>{

	FEMALE(0),MALE(1) ;
	
	int flag;
	private SexEnum(int flag) {
		this.flag = flag;  
	}
	@Override
	public int getFlagValue() {
		return this.flag;
	}
}
