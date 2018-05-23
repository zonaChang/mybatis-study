package com.carl.study.ssm.model.bean;

import org.apache.ibatis.type.Alias;

import com.carl.study.ssm.model.enums.SexEnum;

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
//@Alias("Student") //使用注解定义了别名， 则sqlMapConf.xml中配置的别名， 将失效
public class Student {
	private Long id;
	
	private String name;
	
	private int age;
	
	private String description;
	
	/** 0:女; 1:男 */
	private SexEnum sex;
	
	private String bak;
	
	private Long classesId;
}
