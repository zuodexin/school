package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.po.Course;
import com.zuodexin.po.Schoolclass;
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
	public List<SelectCourse> findGradedCourse(Student student){
		String hql="FROM SelectCourse WHERE student=? and grade!=null";
		List<SelectCourse> list=(List<SelectCourse>) viewer.viewMany(hql, student);
		return list;
	}
	public List<SelectCourse> findUngradedCourse(Student student){
		String hql="FROM SelectCourse WHERE student=? and grade is null";
		List<SelectCourse> list=(List<SelectCourse>) viewer.viewMany(hql, student);
		return list;
	}
	public List<SelectCourse> findBySchoolclass(Schoolclass schoolclass){
		String hql="SELECT S "
				+ "FROM SelectCourse AS S, JionClass AS J "
				+ "WHERE S.student=J.student and J.schoolclass=? ";
		return (List<SelectCourse>) viewer.viewMany(hql, schoolclass);	
	}
}
