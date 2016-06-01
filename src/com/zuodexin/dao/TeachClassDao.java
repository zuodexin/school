package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.po.Course;
import com.zuodexin.po.Professor;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.TeachClass;

public class TeachClassDao extends Dao{

	@Override
	public
	TeachClass findOneById(int id) {
		return (TeachClass) findOneById(id, TeachClass.class);
	}

	@Override
	public
	List<TeachClass> findAll() {
		return (List<TeachClass>) findAll(TeachClass.class);
	}
	
	public TeachClass findByProfessorClass(Professor professor,Schoolclass schoolclass){
		String hql="FROM TeachClass "
				+ "WHERE professor=? and schoolclass=?";
		return (TeachClass) viewer.viewOne(hql, professor,schoolclass);
	}
	
//	public List<TeachClass> findByCourse(Course course){
//		String hql="SELECT T "
//				+"FROM TeachClass AS T,Schoolclass AS S "
//				+"WHERE S.course=? and T.schoolclass=S ";
//		return (List<TeachClass>) viewer.viewMany(hql, course);	
//	}
}
