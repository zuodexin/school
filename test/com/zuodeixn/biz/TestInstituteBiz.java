package com.zuodeixn.biz;

import org.junit.Test;

import com.zuodexin.biz.InstituteBiz;
import com.zuodexin.biz.ProfessorBiz;
import com.zuodexin.po.Course;
import com.zuodexin.po.Institute;
import com.zuodexin.po.Professor;

public class TestInstituteBiz {
	InstituteBiz instituteBiz=new InstituteBiz();
	
	@Test 
	public void testSetUpInstitute(){
		Institute institute=new Institute();
		institute.setName("赛艇学院");
		instituteBiz.addEntity(institute);
	}
	
	@Test 
	public void testHireProfessor(){
		Professor professor=new Professor();
		Institute institute=new Institute();
		professor.setId(11);
		institute.setId(13);
		instituteBiz=new InstituteBiz(institute);
		professor=(Professor) new ProfessorBiz().fillEntity(professor);
		instituteBiz.hireProfessor(professor);
	}
	
	@Test
	public void testOpenCourse(){
		Course course=new Course();
		course.setName("跑步");
		course.setPeroid(20);
		Institute institute=new Institute();
		institute.setId(7);
		instituteBiz=new InstituteBiz(institute);
		if(instituteBiz.openCourse(course)){
			System.out.println("开课成功");
		}
		else{
			System.out.println("开课失败");
		}
	}
}
