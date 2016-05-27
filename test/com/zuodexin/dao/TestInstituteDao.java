package com.zuodexin.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.zuodexin.po.Course;
import com.zuodexin.po.Institute;
import com.zuodexin.util.HibernateUtil;

public class TestInstituteDao {
	InstituteDao instituteDao=new InstituteDao();
	@Test
	public void testInsertOne(){
		Institute institute=new Institute();
		institute.setName("软件学院");
		Course course=new Course();
		course.setName("面向对象软件方法学");
		Set<Course> set=new HashSet<Course>();
		set.add(course);
		institute.setCourses(set);
		instituteDao.insertOne(institute);
	}
	
	@Test
	public void testOneToMany(){
		SessionFactory sessionFactory=HibernateUtil.getFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		session.beginTransaction();
		try{
			Institute institute=session.get(Institute.class,1);
			Course course=new Course();
			course.setName("软件工程");
			course.setInstitute(institute);
			session.save(course);
			session.merge(institute);
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
	}
	@Test 
	public void testfindOne(){
		Institute institute=instituteDao.findOneById(1);
		CourseDao courseDao=new CourseDao();
//		instituteDao.closeSession();
		System.out.println("before insert:"+institute.getCourses().size());
//		Course course=(Course) (institute.getCourses()).toArray()[0];
//		System.out.println(course.getName());
//		course.setName("大学语文");
		Set<Course> courses=institute.getCourses();
		Course course=new Course();
		course.setName("软件工程");
		course.setInstitute(institute);
		courseDao.insertOne(course);
		institute=instituteDao.findOneById(1);
		System.out.println("after insert:"+institute.getCourses().size());
		courseDao.deleteOne(course);
		institute=instituteDao.findOneById(1);
		System.out.println("after remove:"+institute.getCourses().size());
		
	}
	@Test
	public void testInsertMany(){
		List<Institute> list =new ArrayList<Institute>();
		for(int i=0;i<10;i++){
			Institute institute=new Institute();
			institute.setName("学院"+i);
			institute.getCourses();
			list.add(institute);
		}
		instituteDao.insertMany(list);
	}
}
