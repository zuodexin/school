package com.zuodexin.ui.panel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.zuodexin.biz.StudentBiz;
import com.zuodexin.controller.StudentController;
import com.zuodexin.dao.InstituteDao;
import com.zuodexin.po.Course;
import com.zuodexin.po.Institute;
import com.zuodexin.po.SelectCourse;

public class SelectCourseControlPanle extends ControlPanel{
	JLabel label=new JLabel("选择学院");
	JComboBox comboBox=new JComboBox();
	List<Institute> institutes; 
	Course course;
	JButton jbSelect=new JButton("选课");
	
	public SelectCourseControlPanle(JFrame frame){
		super(frame);
		institutes=new InstituteDao().findAll();
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		for(Institute i:institutes){
			comboBox.addItem(i.getName());
		}
		jbSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentBiz biz=StudentController.getInstance().getBiz();
				if(biz.selectCourse(course)){
					JOptionPane.showMessageDialog(null, 
							"恭喜你，选课成功", "选课成功", JOptionPane.PLAIN_MESSAGE); 
				}
				else{
					JOptionPane.showMessageDialog(null, 
							"选课失败", "选课失败", JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
		this.add(label);
		this.add(comboBox);
		this.add(jbSelect);
	}
	public Institute getSelectedInstitute(){
		
		return null;
	}
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public List<Institute> getInstitutes() {
		return institutes;
	}

	public void setInstitutes(List<Institute> institutes) {
		this.institutes = institutes;
	}

	public JButton getJbSelect() {
		return jbSelect;
	}

	public void setJbSelect(JButton jbSelect) {
		this.jbSelect = jbSelect;
	}
	@Override
	public void onItemChanged(Object item) {
		this.course=(Course) item;
	}
	
}
