package com.zuodexin.po;

// Generated 2016-5-27 11:22:51 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import com.zuodexin.po.itf.Refreshable;

/**
 * Course generated by hbm2java
 */
public class Course implements java.io.Serializable,Refreshable {

	private int id;
	private Institute institute;
	private String name;
	private int peroid;
	private Set<SelectCourse> selectCourses = new HashSet<SelectCourse>(0);
	private Set<Schoolclass> schoolclasses = new HashSet<Schoolclass>(0);
	private Set<Instruct> instructs = new HashSet<Instruct>(0);

	public Course() {
	}

	public Course(int id, Institute institute, String name, int peroid) {
		this.id = id;
		this.institute = institute;
		this.name = name;
		this.peroid = peroid;
	}

	public Course(int id, Institute institute, String name, int peroid,
			Set<SelectCourse> selectCourses, Set<Schoolclass> schoolclasses,
			Set<Instruct> instructs) {
		this.id = id;
		this.institute = institute;
		this.name = name;
		this.peroid = peroid;
		this.selectCourses = selectCourses;
		this.schoolclasses = schoolclasses;
		this.instructs = instructs;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Institute getInstitute() {
		return this.institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPeroid() {
		return this.peroid;
	}

	public void setPeroid(int peroid) {
		this.peroid = peroid;
	}

	public Set<SelectCourse> getSelectCourses() {
		return this.selectCourses;
	}

	public void setSelectCourses(Set<SelectCourse> selectCourses) {
		this.selectCourses = selectCourses;
	}

	public Set<Schoolclass> getSchoolclasses() {
		return this.schoolclasses;
	}

	public void setSchoolclasses(Set<Schoolclass> schoolclasses) {
		this.schoolclasses = schoolclasses;
	}

	public Set<Instruct> getInstructs() {
		return this.instructs;
	}

	public void setInstructs(Set<Instruct> instructs) {
		this.instructs = instructs;
	}

}
