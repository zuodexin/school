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

public class Viewer implements DBViewer{
	Dao dao;
	
	public Viewer(Dao dao){
		this.dao=dao;
	}
	
	@Override
	public Object viewOne(String hql,Object... args) {
		List<?> list=this.viewMany(hql, args);
		if(list.size()==0)
			return null;
		return list.get(0);
	}

	@Override
	public List<?> viewMany(String hql, Object... args) {
		Session session=dao.getSession();
		Transaction tx=session.getTransaction();
		session.beginTransaction();
		Query query=session.createQuery(hql);
		int i=0;
		for(Object o:args){
			query.setParameter(i, args[i]);
			i++;
		}
		List<?> result=query.list();
		return result;
	}
}
