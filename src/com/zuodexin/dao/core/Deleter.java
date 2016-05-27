package com.zuodexin.dao.core;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zuodexin.dao.Dao;
import com.zuodexin.dao.core.itf.DBUpdater;
import com.zuodexin.dao.core.itf.DBViewer;
import com.zuodexin.util.HibernateUtil;

public class Deleter implements DBUpdater{
	Dao dao;
	public Deleter(Dao dao) {
		this.dao=dao;
	}

	@Override
	public int updateOne(Object o){
		Session session=dao.getSession();
		Transaction tx=session.getTransaction();
		session.beginTransaction();
		int change;
		try{
			session.delete(o);
			tx.commit();
			change=1;
		}
		catch(Exception e){
			tx.rollback();
			change=0;
		}
		return change;
	}
	
	@Override
	public int updateMany(List<?> list){
		Session session=dao.getSession();
		Transaction tx=session.getTransaction();
		session.beginTransaction();
		int n=0;
		try{
			for(Object o:list){
				session.delete(o);
				n++;
			}
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
			n=0;
		}
		return n;
	}
}
