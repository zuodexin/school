package com.zuodexin.dao.core;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zuodexin.dao.Dao;
import com.zuodexin.dao.core.itf.DBUpdater;
import com.zuodexin.util.HibernateUtil;

public class Inserter implements DBUpdater{
	Dao dao;
	
	public Inserter(Dao dao) {
		this.dao=dao;
	}

	@Override
	public int updateOne(Object o){
		Session session=dao.getSession();
		Transaction tx=session.getTransaction();
		session.beginTransaction();
		try{
			session.save(o);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
			return 0;
		}
		session.clear();
		return 1;
	}
	
	@Override
	public int updateMany(List<?> list){
		Session session=dao.getSession();
		Transaction tx=session.getTransaction();
		session.beginTransaction();
		try{
			for(Object o:list)
				session.save(o);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
			return 0;
		}
		session.clear();
		return list.size();
	}
	
}
