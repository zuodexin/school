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
import com.zuodexin.po.JionClass;
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
		this.refresh();
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
		if(selectCourseDao.findByStudentCourse((Student) entity, course) != null){
			System.out.println("已选过这门课了");
			return true;
		}
		else{
			CourseBiz courseBiz=new CourseBiz();
			courseBiz.setEntity(course);
			List<Schoolclass> classlist=courseBiz.getAvailavleClass();
			if(classlist.size()==0){
				System.out.println("课程未开设班级");
				return false;
			}
			Schoolclass schoolclass=classlist.get(0);
			JionClass jionClass=new JionClass();
			jionClass.setStudent((Student) entity);
			jionClass.setSchoolclass(schoolclass);
			jionClassDao.insertOne(jionClass);
		};
		int n=selectCourseDao.insertOne(selectCourse);
		this.refresh();
		return n==1?true:false;
	}
	//查看课程班级列表
	public List<Schoolclass> getCourseClassList(Course course){
		List<Schoolclass> classList=new SetAdapter<Schoolclass>(course.getSchoolclasses()).toList(); 
		return classList;
	}
	//获得已选课程的班级
	public JionClass getCourseClass(Course course){
		
		return jionClassDao.
				findByStudentCourse((Student)this.entity, course);
	}
	public boolean changeClass(Course course,Schoolclass schoolclass){
		JionClass jionClass=jionClassDao.
				findByStudentCourse((Student)this.entity, course);
		int n=0;
		if(jionClass!=null){
			jionClass.setSchoolclass(schoolclass);
			n=jionClassDao.updateOne(jionClass);
		}	
		return n==1?true:false;
	}
	public void dropCourse(Course course){
		Student student= (Student)this.entity;
		SelectCourse selectcourse;
		if((selectcourse=selectCourseDao.
				findByStudentCourse(student, course) )
				== null) 
			return;
		selectCourseDao.deleteOne(selectcourse);
		JionClass jionClass=jionClassDao.
				findByStudentCourse(student, course);
		if(jionClass!=null){
			jionClassDao.deleteOne(jionClass);
		}
	}
	
	public List<SelectCourse> getSelectedCourse(){
		List<SelectCourse> courseList=new SetAdapter<SelectCourse>(((Student)entity).getSelectCourses()).toList();
		return courseList;
	}
}
