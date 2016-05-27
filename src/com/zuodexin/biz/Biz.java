package com.zuodexin.biz;

import com.zuodexin.dao.Dao;
import com.zuodexin.po.itf.Refreshable;

public abstract class Biz {
	Refreshable entity;
	Dao entityDao;

	protected void refresh(){
		if(entity!=null)
			entity=(Refreshable) entityDao.findOneById(entity.getId());
	}

	public Refreshable getEntity() {
		return entity;
	}

	public void setEntity(Refreshable entity) {
		this.entity = entity;
	}
}
