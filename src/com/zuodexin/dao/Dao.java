package com.zuodexin.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zuodexin.dao.core.Deleter;
import com.zuodexin.dao.core.Inserter;
import com.zuodexin.dao.core.Updater;
import com.zuodexin.dao.core.Viewer;
import com.zuodexin.po.Student;
import com.zuodexin.util.HibernateUtil;

public abstract class Dao {
	SessionFactory sessionFactory=HibernateUtil.getFactory();
	Session session=sessionFactory.openSession();
	
	Inserter inserter=new Inserter(this);
	Deleter deleter= new Deleter(this);
	Updater updater=new Updater(this);
	Viewer viewer=new Viewer(this);
	
	protected void newSession(){
		session.close();
		session=sessionFactory.openSession();
	}
	
	public Object findOneById(int id,Class c){
		newSession();
		String hql="FROM "+c.getName()+" WHERE id= ?";
		Object o=viewer.viewOne(hql,id);
		Hibernate.initialize(o);
		return o;
	};
	public List<?> findAll(Class c){
		newSession();
		String hql="FROM "+c.getName();
		List<?> list=viewer.viewMany(hql);
		return list;
	};
	public abstract Object findOneById(int id);
	public abstract List<?> findAll();
	
	
	public void refresh(){
		
	}
	public int insertOne(Object o) {
		return inserter.updateOne(o);
	}
	
	public int insertMany(List<?> list) {
		return inserter.updateMany(list);
	}
	
	public int deleteMany(List<?> list) {
		return deleter.updateMany(list);
	}

	public int deleteOne(Object o) {
		return deleter.updateOne(o);
	}
	
	public int updateOne(Object o) {
		return updater.updateOne(o);
	}


	public int updateMany(List<?> list) {
		return updater.updateMany(list);
	}
	
	public void closeSession(){
		session.close();
	}
	
	public Session getSession(){
		return this.session;
	}
}
