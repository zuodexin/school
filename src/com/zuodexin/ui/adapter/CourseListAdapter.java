package com.zuodexin.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.zuodexin.po.Course;
import com.zuodexin.ui.widget.MyTableModel;

public class CourseListAdapter implements ListAdapter{
	List<Course> data=new ArrayList<Course>();
	String[] head={ "id", "课程名", "学时" };
	MyTableModel model;
	public CourseListAdapter(){
		
	}
	@Override
	public String[] getHead() {
		return head;
	}

	@Override
	public List itemAttribute(int index) {
		List list=new ArrayList();
		Course course=data.get(index);
		list.add(course.getId());
		list.add(course.getName());
		list.add(course.getPeroid());
		return list;
	}

	@Override
	public int itemCount() {
		return data.size();
	}
	@Override
	public void addItem(Object o) {
		data.add((Course) o);
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
