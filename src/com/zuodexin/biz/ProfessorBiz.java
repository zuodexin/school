package com.zuodexin.biz;

import java.util.ArrayList;
import java.util.List;

import com.zuodexin.dao.InstructDao;
import com.zuodexin.dao.JionClassDao;
import com.zuodexin.dao.ProfessorDao;
import com.zuodexin.dao.SelectCourseDao;
import com.zuodexin.dao.StudentDao;
import com.zuodexin.dao.TeachClassDao;
import com.zuodexin.po.Course;
import com.zuodexin.po.Instruct;
import com.zuodexin.po.JionClass;
import com.zuodexin.po.Professor;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.SelectCourse;
import com.zuodexin.po.Student;
import com.zuodexin.po.TeachClass;
import com.zuodexin.util.SetAdapter;

public class ProfessorBiz extends Biz implements AuthBiz{
	InstructDao instructDao=new InstructDao();
	SelectCourseDao selectCourseDao=new SelectCourseDao();
	JionClassDao jionClassDao=new JionClassDao();
	TeachClassDao teachClassDao=new TeachClassDao();
	
	public ProfessorBiz(){
		this.entityDao=new ProfessorDao();
	}
	public ProfessorBiz(Professor professor){
		this.entity=professor;
		this.entityDao=new ProfessorDao();
		this.refresh();
	}
	
	public boolean Login(String workid,String password){
		ProfessorDao professorDao=(ProfessorDao) entityDao;
		entity=professorDao.findOneByUsernamePassword(workid, password);
		if(entity==null)
			return false;
		return true;
	}
	
	public boolean Regist(Professor professor){
		ProfessorDao professorDao=(ProfessorDao) entityDao;
		int n=professorDao.insertOne(professor);
		if(n==0)
			return false;
		this.entity=professor;
		this.refresh();
		return true;
	}
	
	public void gaveGrades(Course course,Student student,int grade){
		SelectCourse selectCourse=selectCourseDao.findByStudentCourse(student, course);
		selectCourse.setGrade(grade);
		selectCourseDao.updateOne(selectCourse);
	}
	public boolean instructCourse(Course course){
		Instruct instruct=new Instruct();
		instruct.setProfessor((Professor)this.entity);
		instruct.setCourse(course);
		instructDao.insertOne(instruct);
		this.refresh();
		return true;
	}
	
	public List<Instruct> getInstructList(){
		return new SetAdapter<Instruct>(
				((Professor)this.entity).getInstructs()
				).toList();
	}
	
	public List<TeachClass> getTeachClassesList(){
		return new SetAdapter<TeachClass>(
				((Professor)this.entity).getTeachClasses()
				).toList();
	}
	
	
	public boolean teachClass(Schoolclass schoolclass){
		TeachClass teachClass=new TeachClass();
		teachClass.setProfessor((Professor)this.entity);
		teachClass.setSchoolclass(schoolclass);
		teachClassDao.insertOne(teachClass);
		this.refresh();
		return true;
	}
	
	public boolean declineClass(Schoolclass schoolclass){
		TeachClass teachClass =teachClassDao.
				findByProfessorClass((Professor)this.entity, schoolclass);
		if(teachClass!=null){
			teachClassDao.deleteOne(teachClass);
		}
		this.refresh();
		return true;
	}
	
	public List<Student> seeStudentList(Schoolclass schoolclass){
		List<Student> result=new ArrayList<Student>();
		List<JionClass> jlist=jionClassDao.findJoinByClass(schoolclass);
		for(JionClass j:jlist){
			result.add(j.getStudent());
		}
		return result;
	}
	
}
