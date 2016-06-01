package com.zuodexin.ui.panel.pro;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

import com.zuodexin.biz.ProfessorBiz;
import com.zuodexin.controller.ProfessorController;
import com.zuodexin.po.Course;
import com.zuodexin.po.Instruct;
import com.zuodexin.po.TeachClass;
import com.zuodexin.ui.panel.ControlPanel;
import com.zuodexin.ui.panel.SelectDeleteControlPanel;

public class TeachClassControlPanel extends SelectDeleteControlPanel{
	JCheckBox all=new JCheckBox("显示所有");
	List<Instruct> instructList=new ArrayList<Instruct>();
	TeachClass teachClass;
	
	public TeachClassControlPanel(JFrame frame) {
		super(frame, "课程", "教授", "取消教授");
		ProfessorBiz biz=ProfessorController.getInstance().getBiz();
		instructList=biz.getInstructList();
		comboBox.addItem("全部");
		for(Instruct i:instructList){
			Course course=i.getCourse();
			comboBox.addItem(course.getName());
		}
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		this.add(label);
		this.add(comboBox);
		this.add(jbSelect);
		this.add(jbDelete);
		this.add(all);
	}

	@Override
	public void onItemChanged(Object item) {
		teachClass=(TeachClass) item;
	}

}
