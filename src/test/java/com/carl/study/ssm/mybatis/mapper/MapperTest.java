package com.carl.study.ssm.mybatis.mapper;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.carl.study.ssm.mapper.ClassesMapper;
import com.carl.study.ssm.mapper.StudentMapper;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月22日下午9:15:33
 */
public class MapperTest {
	
	private static SqlSession sqlSession;
	private static ClassesMapper classesMapper;
	private static StudentMapper studentMapper;
	
	@BeforeClass
	public static void before() throws IOException {
		
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis/sqlMapCofig.xml"));
		sqlSession = sessionFactory.openSession(true);
		classesMapper = sqlSession.getMapper(ClassesMapper.class);
		studentMapper = sqlSession.getMapper(StudentMapper.class);
	}

	@Test
	public void modifyStudent() {
		
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		studentMapper.modifyStudent("name-modify-p", 1L);
	}
	
	@Test
	public void qryAllClasses() {
		System.out.println(classesMapper.qryAllClasses());
	}
	
	@Test
	public void qryClassesById() {
		System.out.println(classesMapper.qryClassesById(1000L));
	}
	
	@Test
	public void qryClassesAndStuById() {
		System.out.println(classesMapper.qryClassesAndStuById(1000L));
	}
	
	
	/**
	 * 
	 * @desc 一对多
	 * <p>一个classes对应多个student</p>
	 * @author Carl
	 * @create time 2018年5月22日下午9:45:18
	 *
	 */
	@Test
	public void one2more() {
		
		System.out.println(classesMapper.qryClassesOne2more(1L));
	}
}
