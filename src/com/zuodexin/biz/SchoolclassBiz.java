package com.zuodexin.biz;

import java.util.List;

import com.zuodexin.dao.SchoolclassDao;
import com.zuodexin.po.Course;
import com.zuodexin.po.JionClass;
import com.zuodexin.po.Schoolclass;

public class SchoolclassBiz extends Biz{
	
	public SchoolclassBiz(){
		this.entityDao=new SchoolclassDao();
	}
	public SchoolclassBiz(Schoolclass schoolclass){
		this.entity=schoolclass;
		this.entityDao=new SchoolclassDao();
		this.refresh();
	}
	
	
}
