package com.carl.study.ssm.mapper;

import java.util.List;

import com.carl.study.ssm.model.bean.Classes;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月21日下午11:40:27
 */
public interface ClassesMapper {
	
	Classes qryClassesById(long id);
	
	List<Classes> qryClassesAndStuById(Long classesId);
	List<Classes> qryAllClasses();
	Classes qryClassesOne2more(long id);
}
