package com.zuodexin.ui.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.zuodexin.po.Course;
import com.zuodexin.po.Professor;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.TeachClass;
import com.zuodexin.ui.widget.MyTableModel;

public class ClassListAdapter implements ListAdapter{
	String[] head={"id","课程名","班级名","选课人数","教授"};
	List<Schoolclass> data=new ArrayList<Schoolclass>();
	MyTableModel model;
	
	@Override
	public String[] getHead() {
		return head;
	}

	@Override
	public List itemAttribute(int index) {
		Schoolclass schoolclass=data.get(index);
		Course course=schoolclass.getCourse();
		List list=new ArrayList();
		list.add(schoolclass.getId());
		list.add(course.getName());
		list.add(schoolclass.getInfo());
		list.add(schoolclass.getJionClasses().size());
		String teachinfo="";
		Iterator iterator=schoolclass.getTeachClasses().iterator();
		while(iterator.hasNext()){
			TeachClass teachClass2=(TeachClass) iterator.next();
			teachinfo+=teachClass2.getProfessor().getName()+" ";
		}
		list.add(teachinfo);
		return list;
	}

	@Override
	public int itemCount() {
		return data.size();
	}

	@Override
	public void addItem(Object o) {
		data.add((Schoolclass) o);
	}

	@Override
	public Object itemAt(int index) {
		return data.get(index);
	}

	@Override
	public void attachData(List list) {
		data=list;
//		System.out.println("附上数据");
		if(model!=null)
			model.update();
	}

	@Override
	public void attachObserver(MyTableModel model) {
		this.model=model;
//		System.out.println("添加表格观察者");
	}

}
