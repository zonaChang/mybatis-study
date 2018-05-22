package com.carl.study.ssm.model.enums;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月16日下午9:59:19
 */
public enum SexEnum {

	FEMALE(0), MALE(1);
	
	int flag;
	private SexEnum(int flag) {
		this.flag = flag;  
	}
}
