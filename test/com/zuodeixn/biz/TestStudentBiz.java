package com.zuodeixn.biz;

import java.util.List;

import org.junit.Test;

import com.zuodexin.biz.StudentBiz;
import com.zuodexin.dao.InstituteDao;
import com.zuodexin.po.Course;
import com.zuodexin.po.Institute;
import com.zuodexin.po.SelectCourse;

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
		Institute institute= new InstituteDao().findOneById(1);
		studentBiz.Login("1312680","111");
		List<Course> list=studentBiz.getAvailableCourses(institute);
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
	
	
}
