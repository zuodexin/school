package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.po.TeachClass;

public class TeachClassDao extends Dao{

	@Override
	public
	TeachClass findOneById(int id) {
		return (TeachClass) findOneById(id, TeachClass.class);
	}

	@Override
	public
	List<TeachClass> findAll() {
		return (List<TeachClass>) findAll(TeachClass.class);
	}

}
