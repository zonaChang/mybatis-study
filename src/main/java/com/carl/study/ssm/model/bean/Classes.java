package com.carl.study.ssm.model.bean;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月21日下午11:38:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classes {

	private Long id;
	private String name;
	private Set <Student> studentSet;
}
