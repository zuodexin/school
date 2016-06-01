package com.zuodexin.ui.frame;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

import com.zuodexin.biz.ProfessorBiz;
import com.zuodexin.controller.ProfessorController;
import com.zuodexin.po.Instruct;
import com.zuodexin.po.TeachClass;
import com.zuodexin.ui.adapter.ClassListAdapter;
import com.zuodexin.ui.adapter.CourseListAdapter;
import com.zuodexin.ui.adapter.InstructCourseAdapter;
import com.zuodexin.ui.layout.GBC;
import com.zuodexin.ui.panel.ControlPanel;
import com.zuodexin.ui.panel.TablePanel;
import com.zuodexin.ui.panel.pro.TeachClassControlPanel;
import com.zuodexin.ui.panel.stu.SelectCourseControlPanle;
import com.zuodexin.ui.widget.MyTableModel;

public class ProfessorFrame extends BusinessFrame {
	InstructCourseAdapter instructCourseAdapter=new InstructCourseAdapter();
	ClassListAdapter teachClassAdapter=new ClassListAdapter();
	
	TeachClassControlPanel tccp=new TeachClassControlPanel(this);
	
	MyTableModel courseListModel=new MyTableModel(instructCourseAdapter);
	MyTableModel classListModel=new MyTableModel(teachClassAdapter);
	
	List<Instruct> instructList;
	List<TeachClass> teachClasseList;
	
	public ProfessorFrame(){
		this.controlPanel=tccp;
		JMenu usecase = new JMenu("用例");
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem("教授课程");
		menuItem.setSelected(true);
		buttonGroup.add(menuItem);
		usecase.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				remove(rightPanel);
				tablePanel.setTmd(courseListModel);
				revalidate();
			}
		});
		menuItem = new JRadioButtonMenuItem("教授班级");
		buttonGroup.add(menuItem);
		usecase.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add(rightPanel,
				new GBC(3, 0, 2, 3).setFill(GBC.BOTH).setIpad(100, 0)
						.setWeight(1, 1));
				tablePanel.setTmd(classListModel);
				switchControlPanel(tccp);
				revalidate();
			}
		});
		
		menuItem = new JRadioButtonMenuItem("登记成绩");
		buttonGroup.add(menuItem);
		usecase.add(menuItem);
		
		this.menuBar.add(usecase);
		this.setJMenuBar(menuBar);
		refreshData();
		initLayout();
	}
	
	private void initLayout() {
		
		tablePanel=new TablePanel(courseListModel);
		leftPanel.setBackground(Color.BLUE);
		rightPanel.setBackground(Color.YELLOW);
		leftPanel.setLayout(new GridBagLayout());
		leftPanel.add(tablePanel, new GBC(0, 0, 1, 1).setFill(GBC.BOTH)
				.setWeight(1, 1));

		rightPanel.setLayout(new GridBagLayout());
		rightPanel.add(controlPanel, new GBC(0, 0, 1, 1).setFill(GBC.BOTH)
				.setIpad(0, 200).setWeight(1, 1));
		rightPanel.add(infoPanel, new GBC(0, 1, 1, 1).setFill(GBC.BOTH)
				.setIpad(0, 200).setWeight(1, 1));

		this.add(leftPanel,
				new GBC(0, 0, 3, 3).setFill(GBC.BOTH).setIpad(300, 0)
						.setWeight(1, 1));
	}
	public void refreshData(){
		ProfessorBiz biz=ProfessorController.getInstance().getBiz();
		instructList=biz.getInstructList();
		teachClasseList=biz.getTeachClassesList();
		instructCourseAdapter.attachData(instructList);
		teachClassAdapter.attachData(teachClasseList);
		
	}

	public void initListener(){
		
	}
	private void switchControlPanel(ControlPanel panel) {
		rightPanel.remove(controlPanel);
		rightPanel.add(panel,
				new GBC(0, 0, 1, 1).setFill(GBC.BOTH).setIpad(0, 200)
						.setWeight(1, 1));
		controlPanel = panel;
		refreshData();
		rightPanel.revalidate();
	}
}
