package com.zuodeixn.biz;

import org.junit.Test;

import com.zuodexin.biz.StateBiz;
import com.zuodexin.po.State;

public class TestStateBiz {
	@Test
	public void testActivateState(){
		StateBiz stateBiz=new StateBiz();
		State state=stateBiz.getActiveState();
		stateBiz.activateState(state);
//		stateBiz.activateState(StateBiz.SYSTEM_CLOSE);
	}
}
