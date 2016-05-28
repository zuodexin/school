package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.dao.itf.DaoAdapter;
import com.zuodexin.po.Hire;
import com.zuodexin.po.Institute;
import com.zuodexin.po.Professor;

public class HireDao extends Dao implements DaoAdapter{

	@Override
	public Hire findOneById(int id) {
		return (Hire) this.findOneById(id, Hire.class);
	}

	@Override
	public List<Hire> findAll() {
		return (List<Hire>) this.findAll(Hire.class);
	}
	
	public boolean exist(Institute institute,Professor professor){
		String hql="FROM Hire WHERE institute=? and professor=?";
		Hire hire=(Hire) viewer.viewOne(hql, institute,professor);
		return hire==null?false:true;
	}
}
