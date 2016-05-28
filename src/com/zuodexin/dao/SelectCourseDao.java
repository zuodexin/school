package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.po.Course;
import com.zuodexin.po.SelectCourse;
import com.zuodexin.po.Student;

public class SelectCourseDao extends Dao{

	@Override
	public
	SelectCourse findOneById(int id) {
		return (SelectCourse) this.findOneById(id, SelectCourse.class);
	}

	@Override
	public
	List<SelectCourse> findAll() {
		return (List<SelectCourse>) this.findAll(SelectCourse.class);
	}
	
	List<SelectCourse> findByStudentId(int id) {
		String hql="FROM SelectCourse WHERE student= ?";
		return (List<SelectCourse>) viewer.viewMany(hql,id);
	}
	public SelectCourse findByStudentCourse(Student student,Course course){
		String hql="FROM SelectCourse WHERE student=? and course=?";
		SelectCourse c=(SelectCourse) viewer.viewOne(hql, student,course);
		return c;
	}
}
