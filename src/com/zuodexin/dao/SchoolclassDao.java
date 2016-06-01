package com.zuodexin.dao;

import java.util.ArrayList;
import java.util.List;

import com.zuodexin.dao.core.Viewer;
import com.zuodexin.dao.itf.DaoAdapter;
import com.zuodexin.po.Course;
import com.zuodexin.po.JionClass;
import com.zuodexin.po.Schoolclass;

public class SchoolclassDao extends Dao implements DaoAdapter{
	public Schoolclass findOneById(int id) {
		return (Schoolclass)this.findOneById(id, Schoolclass.class);
	}

	public List<Schoolclass> findAll() {
		return (List<Schoolclass>)this.findAll(Schoolclass.class);
	}
	public List<Schoolclass> findByCourse(Course course){
		String hql="FROM Schoolclass "
				+ "WHERE course=? ";
		return  (List<Schoolclass>) viewer.viewMany(hql, course);
	}
}
