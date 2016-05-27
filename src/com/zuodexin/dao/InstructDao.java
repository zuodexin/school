package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.dao.itf.DaoAdapter;
import com.zuodexin.po.Instruct;

public class InstructDao extends Dao implements DaoAdapter{

	@Override
	public Instruct findOneById(int id) {
		return (Instruct) this.findOneById(id,Instruct.class);
	}

	@Override
	public List<Instruct> findAll() {
		return (List<Instruct>) this.findAll(Instruct.class);
	}

}
