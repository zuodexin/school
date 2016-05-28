package com.zuodexin.biz;

import com.zuodexin.dao.HireDao;
import com.zuodexin.dao.InstituteDao;
import com.zuodexin.dao.ProfessorDao;
import com.zuodexin.po.Course;
import com.zuodexin.po.Hire;
import com.zuodexin.po.Institute;
import com.zuodexin.po.Professor;

public class InstituteBiz extends Biz{
	HireDao hireDao=new HireDao();
	public InstituteBiz() {
		this.entityDao=new InstituteDao();
	}
	public InstituteBiz(Institute institute){
		this.entity=institute;
		this.entityDao=new InstituteDao();
		this.refresh();
	}
	
	public boolean openCourse(Course course){
		if(this.entity==null) return false;
		CourseBiz courseBiz=new CourseBiz();
		course.setInstitute((Institute) this.entity);
		try{
			courseBiz.addEntity(course);
			courseBiz.openClass();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void hireProfessor(Professor professor){
		Institute institute=(Institute) this.entity;
		Hire hire=new Hire();
		hire.setInstitute(institute);
		hire.setProfessor(professor);
		hireDao.insertOne(hire);
		this.refresh();
	}
	
}
