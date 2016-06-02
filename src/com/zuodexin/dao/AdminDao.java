package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.po.Admin;

public class AdminDao extends Dao{

	@Override
	public Admin findOneById(int id) {
		return (Admin) this.findOneById(id,Admin.class);
	}

	@Override
	public List<Admin> findAll() {
		return (List<Admin>) this.findAll(Admin.class);
	}
	
	public Admin findByUsernamePassword(String username,String password){
		String hql="FROM Admin "
				+ "WHERE username=? and password=?";
		return (Admin) viewer.viewOne(hql, username, password);
	}
}
