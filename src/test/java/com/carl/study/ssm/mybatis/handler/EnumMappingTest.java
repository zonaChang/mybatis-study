package com.carl.study.ssm.mybatis.handler;

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
import com.carl.study.ssm.model.enums.SexEnum;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月24日上午7:27:36
 */
public class EnumMappingTest {

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
	 * @desc 查询结果映射为枚举
	 * @author Carl
	 * @create time 2018年5月24日上午7:30:02
	 *
	 */
	@Test
	public void qryEnum() {
		List<Student> stu = configMapper.qryStudentByName();
		System.out.println(stu.get(0).getSex().ordinal());
	}
	
	@Test
	public void insertEnum() {
		Student temp = new Student();
		temp.setName("enum");
		temp.setSex(SexEnum.MALE);
		Long id = configMapper.insertStudentByEnum(temp);
		System.out.println(id);
	}
}
