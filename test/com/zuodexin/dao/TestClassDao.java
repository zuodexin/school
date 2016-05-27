package com.zuodexin.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.zuodexin.po.Schoolclass;

public class TestClassDao {
	SchoolclassDao schoolclassDao;
	@Before
	public void setUp(){
		schoolclassDao=new SchoolclassDao();
	}
	
	@Test
	public void InsertMany(){
		List<Schoolclass> list=new ArrayList<Schoolclass>();
		for(int i=1;i<10;i++){
			Schoolclass schoolclass=new Schoolclass();
			list.add(schoolclass);
		}
		
	}
}
