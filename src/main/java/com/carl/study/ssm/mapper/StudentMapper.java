package com.carl.study.ssm.mapper;

import java.util.List;

import com.carl.study.ssm.model.bean.Student;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月17日下午10:25:37
 */
public interface StudentMapper {

	Student qryStudentById(long id);
	
	List<Student> qryStudentByLikeName(String name);
	List<Student> qryStudentByLikeNameFunc(String name);
	Student addStudent(Student student);
	int modifyStudent(String name, long id);
	
	int deleteStudentById(Long id);

	List<Student> queryAllOrderBy(String id);

	List<Student> queryStudentByIds(List<Long> ids);
}
