package com.zuodexin.biz;

import java.util.List;

import com.zuodexin.dao.ProfessorDao;
import com.zuodexin.po.Course;
import com.zuodexin.po.Professor;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.Student;

public class ProfessorBiz extends Biz{
	public ProfessorBiz(){
		this.entityDao=new ProfessorDao();
	}
	public ProfessorBiz(Professor professor){
		this.entity=professor;
		this.entityDao=new ProfessorDao();
		this.refresh();
	}
	public void gaveGrades(Course course,Student student){
		
	}
	public boolean instructClass(Schoolclass schoolclass){
		
		return false;
	}
	
	public boolean declineClass(Schoolclass schoolclass){
		
		return false;
	}
	
	public List<Student> seeStudent(Schoolclass schoolclass){
		
		return null;
	}
	
}
