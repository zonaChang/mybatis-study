package com.carl.study.ssm.mapper;

import java.util.List;

import com.carl.study.ssm.model.bean.Student;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月23日下午8:08:17
 */
public interface ConfigMapper {

	List<Student> qryStudentByName();

}
