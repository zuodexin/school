package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.po.JionClass;

public class JionClassDao extends Dao{

	@Override
	public
	JionClass findOneById(int id) {
		return (JionClass) this.findOneById(id,JionClass.class);
	}

	@Override
	public
	List<JionClass> findAll() {
		return (List<JionClass>) this.findAll(JionClass.class);
	}

}
