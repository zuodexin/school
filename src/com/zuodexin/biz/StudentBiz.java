package com.zuodexin.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.zuodexin.dao.CourseDao;
import com.zuodexin.dao.Dao;
import com.zuodexin.dao.JionClassDao;
import com.zuodexin.dao.SchoolclassDao;
import com.zuodexin.dao.SelectCourseDao;
import com.zuodexin.dao.StudentDao;
import com.zuodexin.po.Course;
import com.zuodexin.po.Institute;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.SelectCourse;
import com.zuodexin.po.Student;
import com.zuodexin.util.SetAdapter;

public class StudentBiz extends Biz{
	CourseDao courseDao=new CourseDao();
	SchoolclassDao classDao=new SchoolclassDao();
	JionClassDao jionClassDao=new JionClassDao();
	SelectCourseDao selectCourseDao=new SelectCourseDao();
	
	public StudentBiz(){
		this.entityDao=new StudentDao();
	}
	public StudentBiz(Student student){
		this.entity=student;
		this.entityDao=new StudentDao();
	}
	public boolean Login(String stuid,String password){
		StudentDao studentDao=(StudentDao) entityDao;
		entity=studentDao.findOneByUsernamePassword(stuid, password);
		if(entity==null)
			return false;
		return true;
	}
	
	public List<Course> getAvailableCourses(Institute institute){
		List<Course> courseList=new SetAdapter<Course>(institute.getCourses()).toList();
		return courseList;
	}
	
	public boolean selectCourse(Course course){
		SelectCourse selectCourse=new SelectCourse();
		selectCourse.setStudent((Student) entity);
		selectCourse.setCourse(course);
		if(selectCourseDao.exist((Student) entity, course)){
			System.out.println("已选过这门课了");
			return true;
		};
		int n=selectCourseDao.insertOne(selectCourse);
		refresh();
		return n==1?true:false;
	}
	public boolean changeClass(Course course,Schoolclass schoolclass){
		
		return false;
	}
	public List<SelectCourse> getSelectedCourse(){
		List<SelectCourse> courseList=new SetAdapter<SelectCourse>(((Student)entity).getSelectCourses()).toList();
		return courseList;
	}
}
