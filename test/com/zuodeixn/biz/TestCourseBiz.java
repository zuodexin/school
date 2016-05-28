package com.zuodeixn.biz;

import java.util.List;

import org.junit.Test;

import com.zuodexin.biz.CourseBiz;
import com.zuodexin.po.Course;
import com.zuodexin.po.Schoolclass;

public class TestCourseBiz {

	@Test
	public void testOpenClass(){
		Course course=new Course();
		course.setId(2);
		CourseBiz courseBiz=new CourseBiz();
		courseBiz.setEntity(course);
		courseBiz.openClass();
	}
	
	@Test
	public void testGetAvailableClass(){
		Course course=new Course();
		course.setId(2);
		CourseBiz courseBiz=new CourseBiz();
		courseBiz.setEntity(course);
		List<Schoolclass> list=courseBiz.getAvailavleClass();
		for(Schoolclass c:list){
			System.out.println(c.getInfo());
		}
	}
	
}
