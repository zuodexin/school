package com.zuodeixn.biz;

import org.junit.Test;

import com.zuodexin.biz.AdminBiz;

public class TestAdminBiz {

	@Test
	public void testLogin(){
		AdminBiz adminBiz=new AdminBiz();
		if(adminBiz.Login("admin", "111")){
			System.out.println("登录成功");
		}
		else{
			System.out.println("登录失败");
		}
	}
}
