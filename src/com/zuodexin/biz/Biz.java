package com.zuodexin.biz;

import java.util.List;

import com.zuodexin.dao.Dao;
import com.zuodexin.dao.ProfessorDao;
import com.zuodexin.po.Professor;
import com.zuodexin.po.itf.Refreshable;

public abstract class Biz {
	Refreshable entity;
	Dao entityDao;
	
	
	protected void refresh(){
		if(entity!=null){
			Refreshable r=(Refreshable) entityDao.findOneById(entity.getId());
			if(r!=null)
				entity=r;
		}
	}
	
	public boolean addEntity(Refreshable entity){
		if(entity!=null){
			if(entityDao.insertOne(entity)==1){
				this.entity=entity;
				this.refresh();
				return true;
			}
			return false;
		}
		return false;
	}
	
	public Refreshable getEntity() {
		return entity;
	}

	public void setEntity(Refreshable entity) {
		this.entity = entity;
		this.refresh();
	}
	
	public Refreshable fillEntity(Refreshable entity){
		Refreshable r=(Refreshable) entityDao.findOneById(entity.getId());
		if(r!=null)
			entity=r;
		return r;
	}
}
