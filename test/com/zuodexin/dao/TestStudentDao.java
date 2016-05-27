package com.zuodexin.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.zuodexin.po.Student;

public class TestStudentDao {
	StudentDao studentDao;
	
	@Before
	public void setUp(){
		studentDao=new StudentDao();
	}
	
	@Test
	public void testInsert(){
		Student student=new Student();
		student.setStuId("1312680");
		student.setName("zuodexin");
		student.setPassword("111");
		int n=studentDao.insertOne(student);
		System.out.println("更改了"+n+"条记录");
	}
	@Test
	public void testInsertMany(){
		List<Student> list=new ArrayList<Student>();
		for(int i=0;i<10;i++){
			Student student=new Student();
			student.setStuId("test"+i);
			student.setName("学生"+i);
			student.setPassword("301");
			list.add(student);
		}
		int n=studentDao.insertMany(list);
		System.out.println("更改了"+n+"条记录");
	}
	@Test
	public void testDeleteOne(){
		Student stu=studentDao.findOneById(2);
		System.out.println(stu.getName());
		int n=studentDao.deleteOne(stu);
		System.out.println("更改了"+n+"条记录");
	}
	 @Test 
	 public void testDeleteMany(){
		List<Student> list=studentDao.findAll();
		int n=studentDao.deleteMany(list);
		System.out.println("更改了"+n+"条记录");
	 }
	 
	 @Test
	 public void testSomething(){
		 Object stu=new Student();
		 System.out.println(stu.getClass());
	 }
	 
}
