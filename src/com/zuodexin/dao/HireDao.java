package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.dao.itf.DaoAdapter;
import com.zuodexin.po.Hire;

public class HireDao extends Dao implements DaoAdapter{

	@Override
	public Hire findOneById(int id) {
		return (Hire) this.findOneById(id, Hire.class);
	}

	@Override
	public List<Hire> findAll() {
		return (List<Hire>) this.findAll(Hire.class);
	}

}
