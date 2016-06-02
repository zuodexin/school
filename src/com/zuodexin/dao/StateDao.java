package com.zuodexin.dao;

import java.util.List;

import com.zuodexin.dao.itf.DaoAdapter;
import com.zuodexin.po.State;

public class StateDao extends Dao{
	@Override
	public Object findOneById(int id) {
		return null;
	}
	@Override
	public List<State> findAll() {
		return (List<State>) this.findAll(State.class);
	}
	public State findActiveState(){
		String hql="FROM State "
				+ "WHERE active=1";
		return (State) viewer.viewOne(hql);
	}
	public State findByName(String name){
		String hql="FROM State "
				+ "WHERE name=?";
		return (State) viewer.viewOne(hql,name);
	}
}
