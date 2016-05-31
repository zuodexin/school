package com.zuodexin.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.zuodexin.biz.StudentBiz;
import com.zuodexin.controller.StudentController;
import com.zuodexin.po.Course;
import com.zuodexin.po.JionClass;
import com.zuodexin.po.SelectCourse;
import com.zuodexin.ui.widget.MyTableModel;

public class SelectedCourseAdatpter implements ListAdapter{
	List<SelectCourse> data=new ArrayList<SelectCourse>();
	String[] head={ "id", "课程","班级"};
	MyTableModel model;
	
	@Override
	public String[] getHead() {
		return head;
	}

	@Override
	public List itemAttribute(int index) {
		StudentBiz biz=StudentController.getInstance().getBiz();
		List list=new ArrayList();
		SelectCourse selectCourse=data.get(index);
		Course course=selectCourse.getCourse();
		JionClass jionClass=biz.getCourseClass(course);
		list.add(selectCourse.getId());
		list.add(course.getName());
		list.add(jionClass.getSchoolclass().getInfo());
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
