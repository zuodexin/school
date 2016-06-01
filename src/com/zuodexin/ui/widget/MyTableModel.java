package com.zuodexin.ui.widget;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.zuodexin.ui.adapter.ListAdapter;



public class MyTableModel extends AbstractTableModel{
	
	ListAdapter adapter;
	
	public MyTableModel(ListAdapter adapter){
		this.adapter=adapter;
	}
	
	@Override
	public int getRowCount() {
		return adapter.itemCount();
	}
	
	@Override
	public String getColumnName(int col) {
	       return adapter.getHead()[col];
	  }
	
	@Override
	public int getColumnCount() {
		return adapter.getHead().length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List list=adapter.itemAttribute(rowIndex);
		return list.get(columnIndex);
	}

	public ListAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(ListAdapter adapter) {
		this.adapter = adapter;
	}

	public void update() {
		this.fireTableDataChanged();
		System.out.println("表格更新");
	}
	
}