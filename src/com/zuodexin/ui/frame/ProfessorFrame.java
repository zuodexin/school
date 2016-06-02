package com.zuodexin.ui.frame;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import com.zuodexin.biz.ProfessorBiz;
import com.zuodexin.controller.ProfessorController;
import com.zuodexin.po.Course;
import com.zuodexin.po.Instruct;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.SelectCourse;
import com.zuodexin.po.Student;
import com.zuodexin.po.TeachClass;
import com.zuodexin.ui.adapter.ClassListAdapter;
import com.zuodexin.ui.adapter.CourseListAdapter;
import com.zuodexin.ui.adapter.GradeListAdapter;
import com.zuodexin.ui.adapter.InstructCourseAdapter;
import com.zuodexin.ui.adapter.StudentListAdapter;
import com.zuodexin.ui.layout.GBC;
import com.zuodexin.ui.panel.ControlPanel;
import com.zuodexin.ui.panel.InfoPanel;
import com.zuodexin.ui.panel.TablePanel;
import com.zuodexin.ui.panel.pro.GaveGradeControlPanel;
import com.zuodexin.ui.panel.pro.TeachClassControlPanel;
import com.zuodexin.ui.panel.stu.SelectCourseControlPanle;
import com.zuodexin.ui.widget.MyTable;
import com.zuodexin.ui.widget.MyTableModel;

public class ProfessorFrame extends BusinessFrame {
	InstructCourseAdapter instructCourseAdapter=new InstructCourseAdapter();
	ClassListAdapter teachClassAdapter=new ClassListAdapter();
	StudentListAdapter studentListAdapter=new StudentListAdapter();
	GradeListAdapter gradeListAdapter=new GradeListAdapter();
	ClassListAdapter g_teachClassAdapter=new ClassListAdapter();
	
	TeachClassControlPanel tccp=new TeachClassControlPanel(this);
	GaveGradeControlPanel ggcp=new GaveGradeControlPanel(this);
	
	TablePanel gradePanel;
	TablePanel studentPanel;
	TablePanel classPanel;
	
	MyTableModel courseListModel=new MyTableModel(instructCourseAdapter);
	MyTableModel classListModel=new MyTableModel(teachClassAdapter);
	MyTableModel studentListModel=new MyTableModel(studentListAdapter);
	MyTableModel gradeListModel=new MyTableModel(gradeListAdapter);
	MyTableModel g_classListModel=new MyTableModel(g_teachClassAdapter);
	
	List<Instruct> instructList;
	List<Schoolclass> teachClasseList;
	List<Student> studentList;
	List<SelectCourse> toGradeList;
	List<Schoolclass> g_teachClassList;
	
	public ProfessorFrame(){
		
		teachClassAdapter.attachObserver(classListModel);
		studentListAdapter.attachObserver(studentListModel);
		gradeListAdapter.attachObserver(gradeListModel);
		g_teachClassAdapter.attachObserver(g_classListModel);
		
		tablePanel=new TablePanel(courseListModel);
		studentPanel=new TablePanel(studentListModel);
		classPanel=new TablePanel(g_classListModel);
		gradePanel=new TablePanel(gradeListModel);
		
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
		menuItem = new JRadioButtonMenuItem("查看班级");
		buttonGroup.add(menuItem);
		usecase.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(rightPanel);
				add(rightPanel,
				new GBC(3, 0, 2, 3).setFill(GBC.BOTH).setIpad(100, 0)
						.setWeight(1, 1));
				tablePanel.setTmd(classListModel);
				switchControlPanel(tccp);
				switchSidePanel(studentPanel);
				revalidate();
			}
		});
		
		menuItem = new JRadioButtonMenuItem("登记成绩");
		buttonGroup.add(menuItem);
		usecase.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(rightPanel);
				add(rightPanel,
				new GBC(3, 0, 2, 3).setFill(GBC.BOTH).setIpad(100, 0)
						.setWeight(1, 1));
				tablePanel.setTmd(gradeListModel);
				switchControlPanel(ggcp);
				switchSidePanel(classPanel);
				revalidate();
			}
		});
		this.menuBar.add(usecase);
		this.setJMenuBar(menuBar);
		initLayout();
		refreshData();
		initListener();
	}
	
	private void initLayout() {
		
		this.controlPanel=tccp;
		this.sidePanel=studentPanel;
		
		leftPanel.setBackground(Color.BLUE);
		rightPanel.setBackground(Color.YELLOW);
		leftPanel.setLayout(new GridBagLayout());
		leftPanel.add(tablePanel, new GBC(0, 0, 1, 1).setFill(GBC.BOTH)
				.setWeight(1, 1));

		rightPanel.setLayout(new GridBagLayout());
		rightPanel.add(controlPanel, new GBC(0, 0, 1, 1).setFill(GBC.BOTH)
				.setIpad(0, 200).setWeight(1, 1));
		rightPanel.add(sidePanel, new GBC(0, 1, 1, 1).setFill(GBC.BOTH)
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
		onItemSelect(null);
	}

	public void initListener(){
		
		tablePanel.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = ((MyTable) e.getSource())
						.rowAtPoint(e.getPoint()); // 获得行位置
				int col = ((MyTable) e.getSource())
						.columnAtPoint(e.getPoint()); // 获得列位置
				MyTableModel model=(MyTableModel) ((MyTable) e.getSource()).getModel();
				onItemSelect(model.getAdapter().itemAt(row));
			}
		});
		classPanel.getTable().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				int row = ((MyTable) e.getSource())
						.rowAtPoint(e.getPoint()); // 获得行位置
				int col = ((MyTable) e.getSource())
						.columnAtPoint(e.getPoint()); // 获得列位置
				MyTableModel model=(MyTableModel) ((MyTable) e.getSource()).getModel();
				onSideItemSelect(model.getAdapter().itemAt(row));
			}
		});
		this.tccp.getComboBox().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
	             {
					 int  index=tccp.getComboBox().getSelectedIndex();
					 ProfessorBiz biz=ProfessorController.
							 getInstance().getBiz();
					 if(index>0){
						 List<Instruct> instructList=tccp.getInstructList();
						 Instruct instruct=instructList.get(index-1);
						 Course course=instruct.getCourse();
						 teachClasseList=biz.getClassList(course); 
					 }
					 else{
						teachClasseList=biz.getTeachClassesList();
					 }
					 teachClassAdapter.attachData(teachClasseList);
					 onItemSelect(null);
	             }
			}
		});
		this.ggcp.getCbCourse().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
	             {
					 int  index=ggcp.getCbCourse().getSelectedIndex();
					 ProfessorBiz biz=ProfessorController.
							 getInstance().getBiz();
					 if(index>0){
						 List<Instruct> instructList=tccp.getInstructList();
						 Instruct instruct=instructList.get(index-1);
						 Course course=instruct.getCourse();
						 g_teachClassList=biz.getTeachClassList(course);
					 }
					 else{
						 g_teachClassList=new ArrayList<Schoolclass>();
					 }
					 g_teachClassAdapter.attachData(g_teachClassList);
	             }
			}
		});
	}
	private void onItemSelect(Object item) {
		if(item instanceof Schoolclass){
			controlPanel.onItemChanged(item);
			Schoolclass schoolclass=(Schoolclass) item;
			ProfessorBiz biz=ProfessorController.getInstance().getBiz();
			studentList=biz.seeStudentList(schoolclass);
			studentListAdapter.attachData(studentList);
		}
		else if(item instanceof SelectCourse){
			ggcp.onItemChanged(item);
		}
	}
	
	private void onSideItemSelect(Object item){
		Schoolclass schoolclass=(Schoolclass) item;
		ProfessorBiz biz=ProfessorController.getInstance().getBiz();
		toGradeList=biz.getGradeList(schoolclass);
		gradeListAdapter.attachData(toGradeList);
	}
	private void switchControlPanel(ControlPanel panel) {
		rightPanel.remove(controlPanel);
		rightPanel.add(panel,
				new GBC(0, 0, 1, 1).setFill(GBC.BOTH).setIpad(0, 200)
						.setWeight(1, 1));
		controlPanel = panel;
		rightPanel.revalidate();
	}
	private void switchSidePanel(TablePanel panel){
		rightPanel.remove(sidePanel);
		rightPanel.add(panel,
				new GBC(0,1, 1, 1).setFill(GBC.BOTH).setIpad(0, 200)
						.setWeight(1, 1));
		sidePanel = panel;
		rightPanel.revalidate();
	}
}
