package com.zuodexin.ui.panel;

import java.awt.Color;
import java.awt.Panel;
import java.util.List;

import javax.swing.JScrollPane;

import com.zuodexin.ui.widget.MyTable;
import com.zuodexin.ui.widget.MyTableModel;

public class TablePanel extends JScrollPane{
	
	MyTable table=new MyTable();
	MyTableModel tmd;
	
	public TablePanel(MyTableModel tmd){
		this.tmd=tmd;
		table.setModel(tmd);
		table.setRowHeight(30);
		this.setViewportView(table);	
	}

	public MyTable getTable() {
		return table;
	}

	public void setTable(MyTable table) {
		this.table = table;
	}

	public MyTableModel getTmd() {
		return tmd;
	}

	public void setTmd(MyTableModel tmd) {
		this.tmd = tmd;
		table.setModel(tmd);
	}
}
