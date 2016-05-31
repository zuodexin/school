package com.zuodexin.controller;

import javax.swing.JOptionPane;

import com.zuodexin.biz.AuthBiz;
import com.zuodexin.biz.StudentBiz;
import com.zuodexin.strategy.LoginStrategy;
import com.zuodexin.ui.frame.BusinessFrame;
import com.zuodexin.ui.frame.LoginFrame;
import com.zuodexin.ui.frame.StudentFrame;
import com.zuodexin.util.HibernateUtil;

public class GlobalController {
	static GlobalController globalController;
	BusinessFrame businessFrame;
	LoginFrame loginFrame=new LoginFrame();
	AuthBiz biz;
	private GlobalController(){
		
	}
	static public GlobalController getInstance(){
		if(globalController==null)
			globalController=new GlobalController();
		return globalController;
	}
	public void Login(LoginStrategy strategy,String stuid,String password){
		biz=strategy.doLogin(stuid, password);
	}
	public void run(){
		HibernateUtil.getFactory();
		loginFrame.setVisible(true);
//		businessFrame=new StudentFrame();
//		businessFrame.setVisible(true);
	}
	public BusinessFrame getBusinessFrame() {
		return businessFrame;
	}
	public void setBusinessFrame(BusinessFrame businessFrame) {
		this.businessFrame = businessFrame;
	}
	public LoginFrame getLoginFrame() {
		return loginFrame;
	}
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	public AuthBiz getBiz() {
		return biz;
	}
	public void setBiz(AuthBiz biz) {
		this.biz = biz;
	}
}
