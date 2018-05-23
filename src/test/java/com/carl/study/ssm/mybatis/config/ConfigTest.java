package com.carl.study.ssm.mybatis.config;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.carl.study.ssm.mapper.ConfigMapper;
import com.carl.study.ssm.model.bean.Student;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月23日下午8:04:30
 */
public class ConfigTest {
	
	private static SqlSessionFactory sessionFactory;
	private static SqlSession sqlSession;
	private static ConfigMapper configMapper;
	@BeforeClass
	public static void beforeHandler() throws IOException {
		sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis/sqlMapCofig.xml"));
		sqlSession = sessionFactory.openSession(true);
		configMapper = sqlSession.getMapper(ConfigMapper.class);
	}
	
	/**
	 * 
	 * @desc 测试参数的替换
	 * @author Carl
	 * @create time 2018年5月23日下午8:07:36
	 *
	 */
	@Test
	public void paramOveried() {
		List<Student> stu = configMapper.qryStudentByName();
		System.out.println(stu);
//		List<Student> stu2 = sessionFactory.openSession(true).getMapper(ConfigMapper.class).qryStudentByName();
		List<Student> stu2 = configMapper.qryStudentByName();
		System.out.println(stu2);
	}

}
