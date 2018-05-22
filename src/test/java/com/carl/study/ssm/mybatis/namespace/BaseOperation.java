package com.carl.study.ssm.mybatis.namespace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.carl.study.ssm.mapper.ClassesMapper;
import com.carl.study.ssm.mapper.StudentMapper;
import com.carl.study.ssm.model.bean.Student;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月16日下午10:28:43
 */
public class BaseOperation {
	
	private static SqlSessionFactory sessionFactory = null;
	private static SqlSession sqlSession = null;
	private static StudentMapper studentMapper  = null;
	private static ClassesMapper classesMapper  = null;
	@BeforeClass
	public static  void pre() throws IOException {
		String configPath = "mybatis/sqlMapCofig.xml"; 
		sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(configPath));
		
		sqlSession = sessionFactory.openSession();
		studentMapper = sqlSession.getMapper(StudentMapper.class);
		classesMapper = sqlSession.getMapper(ClassesMapper.class);
		System.out.println("BaseOperation.pre()");
	}
	
	/*@AfterClass
	public static void after() {
		sqlSession.close();
		System.out.println("BaseOperation.after()");
	}

	@Before
	public void before() {
		System.out.println("BaseOperation.before()");
		
	}*/
	
	@After
	public void afterTest() {
		sqlSession.commit();
		sqlSession.close();
		System.out.println("BaseOperation.afterTest()");
	}
	
	@Test
	public void addStudent() {
		
		Student student = new Student(null, "zona-2", 2, "zona_add_test", 1, "test", 1L);
		
		int count = sqlSession.insert("com.carl.study.ssm.mapper.StudentMapper.addStudent", student);
		System.out.println("count="+count+"; student="+student);
	}
	
	@Test
	public void queryAll() {
		studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = studentMapper.queryAllOrderBy("name");
		System.out.println(studentList);
	}
	@Test
	public void queryStudentByIds() {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1L);
		ids.add(2L);
		ids.add(6L);
		ids.add(7L);
		List<Student> studentList = studentMapper.queryStudentByIds(ids);
		System.out.println(studentList);
	}
	@Test
	public void query() throws IOException {
		
//		
		Student student = sqlSession.selectOne("com.carl.study.ssm.mapper.StudentMapper.qryStudentById", 2L);
		System.out.println(student);
	}
	
	@Test
	public void qryLikeName() {

//		carl\" or 1=1 or name like \"%
		List<Student> studentList = sqlSession.selectList("com.carl.study.ssm.mapper.StudentMapper.qryStudentByLikeName", "carl");
		System.out.println(studentList.size()+":"+studentList);
	}
	
	@Test
	public void qryStudentByLikeNameFunc() {
		
//		carl\" or 1=1 or name like \"%
		List<Student> studentList = sqlSession.selectList("com.carl.study.ssm.mapper.StudentMapper.qryStudentByLikeNameFunc", "carl\" or 1=1 or name like \"%");
		System.out.println(studentList.size()+":"+studentList);
	}
	

	
}
