package com.zuodexin.ui.panel.pro;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.zuodexin.biz.ProfessorBiz;
import com.zuodexin.biz.StateBiz;
import com.zuodexin.controller.ProfessorController;
import com.zuodexin.po.Course;
import com.zuodexin.po.Instruct;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.SelectCourse;
import com.zuodexin.ui.panel.ControlPanel;

public class GaveGradeControlPanel extends ControlPanel{
	JLabel label=new JLabel("选择课程");
	JComboBox cbCourse=new JComboBox();
	JTextField tfGrade=new JTextField(3);
	JButton btnCommit=new JButton("提交");
	
	List<Instruct> instructList=new ArrayList<Instruct>();
	SelectCourse selectCourse;
	
	public GaveGradeControlPanel(JFrame frame) {
		super(frame);
		ProfessorBiz biz=ProfessorController.getInstance().getBiz();
		instructList=biz.getInstructList();
		cbCourse.addItem("选择课程");
		for(Instruct i:instructList){
			Course course=i.getCourse();
			cbCourse.addItem(course.getName());
		}
		btnCommit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StateBiz stateBiz=new StateBiz();
				if(!stateBiz.isGaveGradeAllowed()) {
					JOptionPane.showMessageDialog(null, 
							"打分系统已关闭", "操作失败", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				if(selectCourse!=null);
				ProfessorBiz biz=ProfessorController.getInstance().getBiz();
				biz.gaveGrades(selectCourse.getCourse(),
						selectCourse.getStudent(), 
						Integer.parseInt(tfGrade.getText()));
			}
		});
		disableBtn();
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		this.add(label);
		this.add(cbCourse);
		this.add(tfGrade);
		this.add(btnCommit);
	}

	@Override
	public void onItemChanged(Object item) {
		this.selectCourse=(SelectCourse) item;
		this.tfGrade.setText(selectCourse.getGrade()+"");
		enableBtn();
	}

	public JComboBox getCbCourse() {
		return cbCourse;
	}

	public void setCbCourse(JComboBox cbCourse) {
		this.cbCourse = cbCourse;
	}

	public JTextField getTfGrade() {
		return tfGrade;
	}

	public void setTfGrade(JTextField tfGrade) {
		this.tfGrade = tfGrade;
	}
	public void disableBtn(){
		this.btnCommit.setEnabled(false);
		this.tfGrade.setEditable(false);
	}
	public void enableBtn(){
		this.btnCommit.setEnabled(true);
		this.tfGrade.setEditable(true);
	}
}
