package com.zuodexin.strategy;

import javax.swing.JOptionPane;

import com.zuodexin.biz.AuthBiz;
import com.zuodexin.biz.StudentBiz;
import com.zuodexin.controller.GlobalController;
import com.zuodexin.controller.StudentController;
import com.zuodexin.ui.frame.StudentFrame;


public class StudentLoginStrategy implements LoginStrategy{

	@Override
	public AuthBiz doLogin(String uid, String password) {
		StudentBiz biz=new StudentBiz();
		if(biz.Login(uid, password)){
			StudentController.getInstance().setBiz(biz);
			StudentFrame studentFrame=new StudentFrame();
			GlobalController.getInstance().setBusinessFrame(studentFrame);
			GlobalController.getInstance().getBusinessFrame().setVisible(true);
			GlobalController.getInstance().getLoginFrame().dispose();
//			System.out.println(biz);
			return biz;
		}
		JOptionPane.showMessageDialog(null, 
				"登录失败", "用户名或密码错误", JOptionPane.ERROR_MESSAGE); 
		return biz;
	}
	
}