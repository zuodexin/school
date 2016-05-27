package com.zuodexin.dao;

/*
 * Dao层封装大多数sql语句
 */

import java.util.List;

import com.zuodexin.dao.core.Deleter;
import com.zuodexin.dao.core.Inserter;
import com.zuodexin.dao.core.Updater;
import com.zuodexin.dao.core.Viewer;
import com.zuodexin.dao.itf.DaoAdapter;
import com.zuodexin.po.Student;

public class StudentDao extends Dao implements DaoAdapter{
	public Student findOneById(int id) {
		return (Student) this.findOneById(id,Student.class);
	}

	public List<Student> findAll() {
		return (List<Student>) this.findAll(Student.class);
	}
	
	public Student findOneByStuId(String stuId){
		String hql="FROM Student WHERE stu_id= ?";
		Student student=(Student) viewer.viewOne(hql,stuId);
		return student;
	}
	public Student findOneByUsernamePassword(String stuid,String password){
		String hql="FROM Student WHERE stu_id= ? and password= ?";
		return (Student) viewer.viewOne(hql,stuid,password);
	}
}
