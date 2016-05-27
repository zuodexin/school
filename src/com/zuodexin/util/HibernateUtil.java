package com.zuodexin.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	static SessionFactory sessionFactory;
	public static  SessionFactory getFactory() {
		if(sessionFactory==null){
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure().build();
		return sessionFactory = new MetadataSources(registry).buildMetadata()
				.buildSessionFactory();
		}
		else{
			return sessionFactory;
		}
	}
	public static void shutDownFactory(){
		if(sessionFactory!=null){
			sessionFactory.close();
			sessionFactory=null;
		}
	}
}
