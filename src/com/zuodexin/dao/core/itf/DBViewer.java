package com.zuodexin.dao.core.itf;

import java.util.List;

public interface DBViewer {
	public Object viewOne(String hql,Object... args);
	public List<?> viewMany(String hql,Object... args);
}
