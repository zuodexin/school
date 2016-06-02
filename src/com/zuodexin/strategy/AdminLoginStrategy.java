package com.zuodexin.strategy;

import javax.swing.JOptionPane;

import com.zuodexin.biz.AdminBiz;
import com.zuodexin.biz.AuthBiz;
import com.zuodexin.controller.AdminController;
import com.zuodexin.controller.GlobalController;
import com.zuodexin.ui.frame.AdminFrame;

public class AdminLoginStrategy implements LoginStrategy{

	@Override
	public AuthBiz doLogin(String uid, String password) {
		AdminBiz biz=new AdminBiz();
		if(biz.Login(uid, password)){
			AdminFrame adminFrame=new AdminFrame();
			AdminController.getInstance().setBiz(biz);
			GlobalController.getInstance().setBusinessFrame(adminFrame);
			GlobalController.getInstance().getBusinessFrame().setVisible(true);
			GlobalController.getInstance().getLoginFrame().dispose();
			return biz;
		}
		JOptionPane.showMessageDialog(null, 
				"登录失败", "用户名或密码错误", JOptionPane.ERROR_MESSAGE); 
		return biz;
	}

}
