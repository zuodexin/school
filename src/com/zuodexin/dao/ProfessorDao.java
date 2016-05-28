package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.dao.core.Viewer;
import com.zuodexin.dao.itf.DaoAdapter;
import com.zuodexin.po.Professor;
import com.zuodexin.po.itf.Refreshable;

public class ProfessorDao extends Dao implements DaoAdapter{

	public Professor findOneById(int id) {
		return (Professor) this.findOneById(id, Professor.class);
	}

	public List<Professor> findAll() {
		return (List<Professor>) this.findAll(Professor.class);
	}

	public Professor findOneByUsernamePassword(String workid, String password) {
		String hql="FROM Professor WHERE work_id= ? and password= ?";
		return (Professor) viewer.viewOne(hql,workid,password);
	}
}
