package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.dao.core.Viewer;
import com.zuodexin.dao.itf.DaoAdapter;
import com.zuodexin.po.Professor;

public class ProfessorDao extends Dao implements DaoAdapter{

	public Professor findOneById(int id) {
		return (Professor) this.findOneById(id, Professor.class);
	}

	public List<Professor> findAll() {
		return (List<Professor>) this.findAll(Professor.class);
	}
}
