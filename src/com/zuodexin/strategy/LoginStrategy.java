package com.zuodexin.strategy;

import com.zuodexin.biz.AuthBiz;

public interface LoginStrategy {
	public AuthBiz doLogin(String uid,String password);
}