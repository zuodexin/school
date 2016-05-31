package com.zuodeixn.biz;

import java.util.List;

import org.junit.Test;

import com.zuodexin.biz.CourseBiz;
import com.zuodexin.biz.StudentBiz;
import com.zuodexin.dao.InstituteDao;
import com.zuodexin.po.Course;
import com.zuodexin.po.Institute;
import com.zuodexin.po.JionClass;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.SelectCourse;
import com.zuodexin.po.Student;

public class TestStudentBiz {
	StudentBiz studentBiz=new StudentBiz();
	
	@Test
	public void testLogin(){
		if(studentBiz.Login("1312680","111")){
			System.out.println("登录成功");
		}
		else{
			System.out.println("用户名或密码错误");
		}
	}
	
	@Test
	public void testSelectCourse(){
		Institute institute= new InstituteDao().findOneById(12);
		studentBiz.Login("1312680","111");
		List<Course> list=studentBiz.getAvailableCourses(institute);
		System.out.println("课程列表：");
		for(Course c:list){
			System.out.println(c.getName());
		}
		List<SelectCourse> selectedList=studentBiz.getSelectedCourse();
		for(SelectCourse s:selectedList){
			System.out.println("你选择了"+s.getCourse().getName());
		}
		
		if(!studentBiz.selectCourse(list.get(0))){
			System.out.println("选课失败");
		};
		
		selectedList=studentBiz.getSelectedCourse();
		System.out.println("已选"+selectedList.size()+"门");
		for(SelectCourse s:selectedList){
			System.out.println("你选择了"+s.getCourse().getName());
		}
	}
	
	
	@Test 
	public void testDropCourse(){
		testLogin();
		Student student=(Student) studentBiz.getEntity();
		List<SelectCourse> list=studentBiz.getSelectedCourse();
		for(SelectCourse s:list){
			System.out.println("你选择了"+s.getCourse().getName());
		}
		studentBiz.dropCourse(list.get(0).getCourse());
	}
	
	@Test
	public void testChangeClass(){
		testLogin();
		Student student=(Student) studentBiz.getEntity();
		List<SelectCourse> list=studentBiz.getSelectedCourse();
		for(SelectCourse s:list){
			System.out.println("你选择了"+s.getCourse().getName());
		}
		Course course=list.get(0).getCourse();
		JionClass jionClass=studentBiz.getCourseClass(course);
		System.out.println("班级："+jionClass.getSchoolclass().getInfo());
		List<Schoolclass> classlist=studentBiz.getCourseClassList(course);
		for(Schoolclass s:classlist){
			System.out.println(s.getInfo());
		}
		studentBiz.changeClass(course,classlist.get(1));
		jionClass=studentBiz.getCourseClass(course);
		System.out.println("班级："+jionClass.getSchoolclass().getInfo());
	}
	
	@Test
	public void testViewSelectedCourse(){
		studentBiz.Login("1312680", "111");
		List<SelectCourse> selectCourses=studentBiz.getSelectedCourse();
//		List<SelectCourse> selectCourses=studentBiz.getFinishCourse();
		System.out.println("已选课程详情");
		for(SelectCourse s:selectCourses){
			System.out.println(s.getCourse().getName()+"  "+s.getGrade()+"分");
		}
	}
	
	
}
