package com.zuodexin.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.zuodexin.po.SelectCourse;
import com.zuodexin.ui.widget.MyTableModel;

public class GradeListAdapter implements ListAdapter{
	String[] head={"学号","姓名","分数"};
	List<SelectCourse> data=new ArrayList<SelectCourse>();
	MyTableModel model;
	
	@Override
	public String[] getHead() {
		return head;
	}

	@Override
	public List itemAttribute(int index) {
		SelectCourse selectCourse=data.get(index);
		List list=new ArrayList();
		list.add(selectCourse.getStudent().getStuId());
		list.add(selectCourse.getStudent().getName());
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
