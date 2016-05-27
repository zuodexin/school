package com.zuodexin.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.zuodexin.po.Course;

public class SetAdapter<T> {
	Set set;
	public SetAdapter(Set<T> set){
		this.set=set;
	}
	public List<T> toList(){
		List<T> list=new ArrayList<T>();
		Iterator<T> iterator=set.iterator();
		while(iterator.hasNext()){
			T item=iterator.next();
			list.add(item);
		}
		return list;
	}
}
