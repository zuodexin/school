package com.zuodeixn.biz;

import org.junit.Test;

import com.zuodexin.biz.InstituteBiz;
import com.zuodexin.po.Institute;

public class TestInstituteBiz {
	InstituteBiz instituteBiz=new InstituteBiz();
	
	@Test 
	public void testSetUpInstitute(){
		Institute institute=new Institute();
		institute.setName("赛艇学院");
		instituteBiz.setUpInstitute(institute);
	}
}
