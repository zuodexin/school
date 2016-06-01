package com.zuodexin.controller;

import java.util.ArrayList;
import java.util.List;

import com.zuodexin.biz.InstituteBiz;
import com.zuodexin.biz.StudentBiz;
import com.zuodexin.po.Course;
import com.zuodexin.po.Institute;

public class StudentController {
	
	private static  StudentController studentController;
	StudentBiz biz;
	private StudentController(){
		
	}
	static public StudentController getInstance(){
		if(studentController==null){
			studentController=new StudentController();
		}
		return studentController;
	}
	
//	public List<Listable> getAvailableCourse(){
//		InstituteBiz instituteBiz=new InstituteBiz();
//		Institute institute=new Institute();
//		institute.setId(13);
//		institute=(Institute) instituteBiz.fillEntity(institute);
//		System.out.println(biz);
//		List list=biz.getAvailableCourses(institute);
//		System.out.println("可选课程数"+list.size());
//		return list;
//	}
	
	public StudentBiz getBiz() {
		return biz;
	}
	public void setBiz(StudentBiz biz) {
		this.biz = biz;
	}
	
}
