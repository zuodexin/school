package com.zuodexin.biz;

import com.zuodexin.dao.AdminDao;
import com.zuodexin.po.Admin;

public class AdminBiz extends Biz implements AuthBiz{

	public AdminBiz() {
		this.entityDao=new AdminDao();
	}
	public AdminBiz(Admin admin){
		this.entity=admin;
		this.entityDao=new AdminDao();
		this.refresh();
	}
	@Override
	public boolean Login(String username, String password) {
		AdminDao adminDao=(AdminDao) this.entityDao;
		entity=adminDao.findByUsernamePassword(username, password);
		if(entity==null)
			return false;
		return true;
	}
	
}
