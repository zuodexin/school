package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.dao.itf.DaoAdapter;
import com.zuodexin.po.Course;

public class CourseDao extends Dao implements DaoAdapter {

	@Override
	public Course findOneById(int id) {
		return (Course) this.findOneById(id, Course.class);
	}

	@Override
	public List<Course> findAll() {
		return (List<Course>) this.findAll(Course.class);
	}
}
