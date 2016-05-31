package com.zuodexin.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.zuodexin.po.SelectCourse;
import com.zuodexin.ui.widget.MyTableModel;

public class FinishCourseAdapter implements ListAdapter{
	List<SelectCourse> data=new ArrayList<SelectCourse>();
	String[] head={ "id", "课程","分数"};
	MyTableModel model;
	
	@Override
	public String[] getHead() {
		return head;
	}

	@Override
	public List itemAttribute(int index) {
		List list=new ArrayList();
		SelectCourse selectCourse=data.get(index);
		list.add(selectCourse.getId());
		list.add(selectCourse.getCourse().getName());
		list.add(selectCourse.getGrade());
		return list;
	}

	@Override
	public int itemCount() {
		return data.size();
	}

	@Override
	public void addItem(Object o) {	
		data.add((SelectCourse) o);
	}
	
	@Override
	public Object itemAt(int index) {
		return data.get(index);
	}
	@Override
	public void attachData(List list) {
		this.data=list;
		if(model!=null)
			model.update();
	}

	@Override
	public void attachObserver(MyTableModel model) {
		this.model=model;
	}
}
