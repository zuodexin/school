package com.zuodexin.dao.core.itf;

import java.util.List;

import com.zuodexin.dao.Dao;

public interface DBUpdater {
	public int updateOne(Object o);
	public int updateMany(List<?> list);
}
