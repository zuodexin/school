package com.zuodexin.controller;

import com.zuodexin.biz.AdminBiz;

public class AdminController {
	static AdminController adminController;
	AdminBiz biz;
	private AdminController(){
		
	}
	public static AdminController getInstance(){
		if(adminController==null){
			adminController=new AdminController();
		}
		return adminController;
	}
	public AdminBiz getBiz() {
		return biz;
	}
	public void setBiz(AdminBiz biz) {
		this.biz = biz;
	}
	
}
