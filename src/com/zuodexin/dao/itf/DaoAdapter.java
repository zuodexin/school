package com.zuodexin.dao.itf;

import java.util.List;

public interface DaoAdapter {
	public Object findOneById(int id);
	public List<?> findAll();
}
