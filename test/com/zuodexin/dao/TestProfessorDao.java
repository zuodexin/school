package com.zuodexin.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.zuodexin.po.Professor;
import com.zuodexin.po.Student;

public class TestProfessorDao {
	ProfessorDao professorDao;
	
	@Before
	public void setUp(){
		professorDao=new ProfessorDao();
	}
	
	@Test
	public void testInsertMany(){
		List<Professor> list=new ArrayList<Professor>();
		for(int i=0;i<10;i++){
			Professor professor=new Professor();
			professor.setWorkId("test"+i);
			professor.setName("教授"+i);
			professor.setPassword("301");
			list.add(professor);
		}
		int n=professorDao.insertMany(list);
		System.out.println("更改了"+n+"条记录");
	}
}
