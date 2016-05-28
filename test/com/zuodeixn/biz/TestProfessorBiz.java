package com.zuodeixn.biz;

import org.junit.Test;

import com.zuodexin.biz.ProfessorBiz;
import com.zuodexin.po.Professor;

public class TestProfessorBiz {
	ProfessorBiz professorBiz;
	
	@Test
	public void testAddProfessor(){
		Professor professor=new Professor();
		professor.setName("教授甲");
		professor.setPassword("123");
		professor.setWorkId("2121");
		professorBiz=new ProfessorBiz();
		professorBiz.addEntity(professor);
	}
}
