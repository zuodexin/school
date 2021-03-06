package com.zuodexin.strategy;

import javax.swing.JOptionPane;

import com.zuodexin.biz.AuthBiz;
import com.zuodexin.biz.ProfessorBiz;
import com.zuodexin.controller.GlobalController;
import com.zuodexin.controller.ProfessorController;
import com.zuodexin.po.Professor;
import com.zuodexin.ui.frame.ProfessorFrame;

public class ProfessorLoginStrategy implements LoginStrategy{

	@Override
	public AuthBiz doLogin(String uid, String password) {
		ProfessorBiz biz=new ProfessorBiz();
		if(biz.Login(uid, password)){
			ProfessorController.getInstance().setBiz(biz);
			ProfessorFrame professorFrame=new ProfessorFrame();
			GlobalController.getInstance().setBusinessFrame(professorFrame);
			GlobalController.getInstance().getBusinessFrame().setVisible(true);
			GlobalController.getInstance().getLoginFrame().dispose();
			return biz;
		}
		JOptionPane.showMessageDialog(null, 
				"登录失败", "用户名或密码错误", JOptionPane.ERROR_MESSAGE); 
		return biz;
	}

}
