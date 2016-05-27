package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.dao.core.Viewer;
import com.zuodexin.dao.itf.DaoAdapter;
import com.zuodexin.po.Institute;

public class InstituteDao extends Dao implements DaoAdapter {

	public Institute findOneById(int id) {
		return (Institute) this.findOneById(id, Institute.class);
	}

	public List<Institute> findAll() {
		return (List<Institute>) this.findAll(Institute.class);
	}

}
