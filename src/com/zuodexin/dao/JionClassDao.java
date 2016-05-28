package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.po.Course;
import com.zuodexin.po.JionClass;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.Student;

public class JionClassDao extends Dao{

	@Override
	public
	JionClass findOneById(int id) {
		return (JionClass) this.findOneById(id,JionClass.class);
	}

	@Override
	public
	List<JionClass> findAll() {
		return (List<JionClass>) this.findAll(JionClass.class);
	}
	
	public JionClass findByStudentSchoolclass(Student student,Schoolclass schoolclass){
		String hql="FROM JionClass WHERE student=? and schoolclass=?";
		return (JionClass) viewer.viewOne(hql, student,schoolclass);
	}
	public JionClass findByStudentCourse(Student student,Course course){
		String hql="SELECT J "
				+ "FROM JionClass AS J,Schoolclass AS S "
				+ " WHERE J.student=? "
				+ "and S.course=? and J.schoolclass=S";
		return (JionClass) viewer.viewOne(hql, student,course);
	}
	
	public List<JionClass> findJoinByClass(Schoolclass schoolclass){
		String hql="FROM  JionClass WHERE schoolclass=? ";
		return (List<JionClass>) viewer.viewMany(hql, schoolclass);
	}
}
