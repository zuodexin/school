package com.zuodexin.po;

import java.util.ArrayList;
import java.util.List;

import com.zuodexin.biz.StudentBiz;
import com.zuodexin.controller.StudentController;
import com.zuodexin.po.itf.Refreshable;

// Generated 2016-5-27 11:22:51 by Hibernate Tools 4.0.0

/**
 * SelectCourse generated by hbm2java
 */
public class SelectCourse implements java.io.Serializable ,Refreshable{

	private int id;
	private Course course;
	private Student student;
	private Integer grade;

	public SelectCourse() {
	}

	public SelectCourse(int id, Course course, Student student) {
		this.id = id;
		this.course = course;
		this.student = student;
	}

	public SelectCourse(int id, Course course, Student student, Integer grade) {
		this.id = id;
		this.course = course;
		this.student = student;
		this.grade = grade;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
}
