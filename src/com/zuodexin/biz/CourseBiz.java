package com.zuodexin.biz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.zuodexin.dao.CourseDao;
import com.zuodexin.dao.SchoolclassDao;
import com.zuodexin.po.Course;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.Student;

public class CourseBiz extends Biz {
	
	public CourseBiz(){
		this.entityDao=new CourseDao();
	}
	public CourseBiz(Course course){
			this.entity=course;
			this.entityDao=new CourseDao();
			this.refresh();
	}
	public int openClass(){
		SchoolclassBiz schoolclassBiz=new SchoolclassBiz();
		Course course=(Course) this.getEntity();
		int n=0;
		for(int i=1;i<=4;i++){
			Schoolclass schoolclass=new Schoolclass();
			schoolclass.setCourse(course);
			schoolclass.setInfo(course.getName()+" "+i+"班");
			n+=schoolclassBiz.addEntity(schoolclass)?1:0;
		}
		return n;
	}
	
	//返回一个班级人数最少的班级
	public List<Schoolclass> getAvailavleClass(){
		Course course=(Course) this.entity;
		List<Schoolclass> result=new ArrayList<Schoolclass>();
		for(Schoolclass s:course.getSchoolclasses()){
			result.add(s);
		}
		Collections.sort(result,new Comparator<Schoolclass>() {
			@Override
			public int compare(Schoolclass o1, Schoolclass o2) {
				int a=o1.getJionClasses().size();
				int b=o2.getJionClasses().size();
				return a-b;
			}
		});
		return result;
	}
	
	public Schoolclass getStudentClass(Student student){
		
		return null;	
	}
}
