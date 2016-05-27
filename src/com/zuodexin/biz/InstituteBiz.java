package com.zuodexin.biz;

import com.zuodexin.dao.InstituteDao;
import com.zuodexin.po.Institute;

public class InstituteBiz extends Biz{
	
	public InstituteBiz() {
		this.entityDao=new InstituteDao();
	}
	public InstituteBiz(Institute institute){
		this.entity=institute;
		this.entityDao=new InstituteDao();
	}
	public boolean setUpInstitute(Institute institute){
		InstituteDao instituteDao=(InstituteDao) entityDao;
		if(instituteDao.insertOne(institute)==1){
			this.entity=institute;
			this.refresh();
			return true;
		}
		return false;
	}
	
	
}
