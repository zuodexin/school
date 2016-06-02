package com.zuodexin.ui.panel.pro;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.zuodexin.biz.ProfessorBiz;
import com.zuodexin.biz.StateBiz;
import com.zuodexin.controller.ProfessorController;
import com.zuodexin.po.Course;
import com.zuodexin.po.Instruct;
import com.zuodexin.po.Professor;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.TeachClass;
import com.zuodexin.ui.frame.ProfessorFrame;
import com.zuodexin.ui.panel.ControlPanel;
import com.zuodexin.ui.panel.SelectDeleteControlPanel;

public class TeachClassControlPanel extends SelectDeleteControlPanel{
	List<Instruct> instructList=new ArrayList<Instruct>();
	Schoolclass schoolclass;
	
	public TeachClassControlPanel(JFrame frame) {
		super(frame, "课程", "授课", "取消授课");
		ProfessorBiz biz=ProfessorController.getInstance().getBiz();
		instructList=biz.getInstructList();
		comboBox.addItem("我的班级");
		for(Instruct i:instructList){
			Course course=i.getCourse();
			comboBox.addItem(course.getName());
		}
		jbSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StateBiz stateBiz=new StateBiz();
				if(!stateBiz.isTeachClassAllowed()) {
					JOptionPane.showMessageDialog(null, 
							"选课系统已关闭", "操作失败", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				if(schoolclass==null) return;
				ProfessorBiz biz=ProfessorController.getInstance().getBiz();
				biz.teachClass(schoolclass);
				((ProfessorFrame)parentFrame).refreshData();
				schoolclass=null;
			}
		});
		jbDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StateBiz stateBiz=new StateBiz();
				if(!stateBiz.isTeachClassAllowed()) {
					JOptionPane.showMessageDialog(null, 
							"选课系统已关闭", "操作失败", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				if(schoolclass==null) return;
				ProfessorBiz biz=ProfessorController.getInstance().getBiz();
				biz.declineClass(schoolclass);
				((ProfessorFrame)parentFrame).refreshData();
				schoolclass=null;
			}
		});
		jbSelect.setEnabled(false);
		jbDelete.setEnabled(false);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		this.add(label);
		this.add(comboBox);
		this.add(jbSelect);
		this.add(jbDelete);
	}

	@Override
	public void onItemChanged(Object item) {
		schoolclass=(Schoolclass) item;
		if(schoolclass==null){
			jbDelete.setEnabled(false);
			jbSelect.setEnabled(false);
			return;
		}
		ProfessorBiz biz=ProfessorController.getInstance().getBiz();
		if(biz.IsClassTeacher(schoolclass)){
			jbDelete.setEnabled(true);
			jbSelect.setEnabled(false);
		}
		else{
			jbSelect.setEnabled(true);
			jbDelete.setEnabled(false);
		}
	}

	public List<Instruct> getInstructList() {
		return instructList;
	}

	public void setInstructList(List<Instruct> instructList) {
		this.instructList = instructList;
	}
	
}
