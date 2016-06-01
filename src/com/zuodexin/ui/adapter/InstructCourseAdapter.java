package com.zuodexin.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.zuodexin.po.Course;
import com.zuodexin.po.Instruct;
import com.zuodexin.ui.widget.MyTableModel;

public class InstructCourseAdapter implements ListAdapter{

	String[] head={ "id", "课程"};
	List<Instruct> data=new ArrayList<Instruct>();
	MyTableModel model;
	
	@Override
	public String[] getHead() {
		return head;
	}

	@Override
	public List itemAttribute(int index) {
		Course course=data.get(index).getCourse();
		List list=new ArrayList();
		list.add(course.getId());
		list.add(course.getName());
		return list;
	}

	@Override
	public int itemCount() {
		return data.size();
	}

	@Override
	public void addItem(Object o) {
		data.add((Instruct) o);
	}

	@Override
	public Object itemAt(int index) {
		return data.get(index);
	}

	@Override
	public void attachData(List list) {
		data=list;
		if(model!=null)
			model.update();
	}

	@Override
	public void attachObserver(MyTableModel model) {
		this.model=model;
	}

}
