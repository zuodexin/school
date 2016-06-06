package com.zuodexin.ui.widget;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class MyTable extends JTable {

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return false;
		}
		return true;
	}
//	@Override
//	public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
//		DefaultTableCellRenderer tableRenderer = (DefaultTableCellRenderer) super
//		.getDefaultRenderer(columnClass);
//		// 设置单元格内容居中显示
//		tableRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
//		// 注意这个的CENTER这个系统变量
//		return tableRenderer;
//	}
}
