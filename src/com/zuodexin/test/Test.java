package com.zuodexin.test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zuodexin.dao.ProfessorDao;
import com.zuodexin.dao.StudentDao;
import com.zuodexin.po.Professor;
import com.zuodexin.po.Student;
import com.zuodexin.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		ProfessorDao professorDao=new ProfessorDao();
		
		HibernateUtil.shutDownFactory();
	}
}
