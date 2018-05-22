package com.carl.study.ssm.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月16日下午9:57:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	private Long id;
	
	private String name;
	
	private int age;
	
	private String description;
	
	/** 0:女; 1:男 */
	private int sex;
	
	private String bak;
	
	private Long classesId;
}
