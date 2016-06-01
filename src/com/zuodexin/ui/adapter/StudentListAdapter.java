package com.zuodexin.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.zuodexin.po.Student;
import com.zuodexin.ui.widget.MyTableModel;

public class StudentListAdapter implements ListAdapter{
	String[] head={"id","学号","姓名"};
	List<Student> data;
	MyTableModel model;
	
	@Override
	public String[] getHead() {
		return head;
	}

	@Override
	public List itemAttribute(int index) {
		Student student=data.get(index);
		List list=new ArrayList();
		list.add(student.getId());
		list.add(student.getStuId());
		list.add(student.getName());
		return list;
	}

	@Override
	public int itemCount() {
		return data.size();
	}

	@Override
	public void addItem(Object o) {
		data.add((Student) o);
	}

	@Override
	public Object itemAt(int index) {
		return data.get(index);
	}

	@Override
	public void attachData(List list) {
		data=list;
		if(model!=null){
			model.update();
		}
	}

	@Override
	public void attachObserver(MyTableModel model) {
		this.model=model;
	}

}
