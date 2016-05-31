package com.zuodexin.ui.adapter;

import java.util.List;

import com.zuodexin.ui.widget.MyTableModel;

public interface ListAdapter {
	public String[] getHead();
	public List itemAttribute(int index);
	public int itemCount();
	public void addItem(Object o);
	public Object itemAt(int index);
	public void attachData(List list);
	public void attachObserver(MyTableModel model);
}
