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
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

import com.zuodexin.biz.StudentBiz;
import com.zuodexin.controller.StudentController;
import com.zuodexin.po.Course;
import com.zuodexin.po.Institute;
import com.zuodexin.ui.adapter.CourseListAdapter;
import com.zuodexin.ui.adapter.FinishCourseAdapter;
import com.zuodexin.ui.adapter.SelectedCourseAdatpter;
import com.zuodexin.ui.layout.GBC;
import com.zuodexin.ui.panel.ControlPanel;
import com.zuodexin.ui.panel.SelectCourseControlPanle;
import com.zuodexin.ui.panel.SelectedCourseControlPanel;
import com.zuodexin.ui.panel.TablePanel;
import com.zuodexin.ui.widget.MyTable;
import com.zuodexin.ui.widget.MyTableModel;

public class StudentFrame extends BusinessFrame {
	CourseListAdapter courseListAdapter=new CourseListAdapter();
	SelectedCourseAdatpter selectedCourseAdatpter=new SelectedCourseAdatpter();
	FinishCourseAdapter finishCourseAdapter=new FinishCourseAdapter();
	
	MyTableModel availiableCourseTmd = new MyTableModel(courseListAdapter);
	MyTableModel selectedCourseTmd = new MyTableModel(selectedCourseAdatpter);
	MyTableModel finishCourseTmd = new MyTableModel(finishCourseAdapter);
	SelectCourseControlPanle sccp = new SelectCourseControlPanle(this);
	SelectedCourseControlPanel sdccp = new SelectedCourseControlPanel(this);
	List availableCourse;
	List selectedCourse;
	List finishCourse;
	
	int tableselected;
	
	public StudentFrame() {
		super();
		courseListAdapter.attachObserver(availiableCourseTmd);
		selectedCourseAdatpter.attachObserver(selectedCourseTmd);
		finishCourseAdapter.attachObserver(finishCourseTmd);
		
		tablePanel = new TablePanel(availiableCourseTmd);
		this.controlPanel = sccp;
		
		JMenu usecase = new JMenu("用例");

		ButtonGroup buttonGroup = new ButtonGroup();

		JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem("可选课程");
		menuItem.setSelected(true);
		buttonGroup.add(menuItem);
		usecase.add(menuItem);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("查看可选课程");
				tablePanel.setTmd(availiableCourseTmd);
				switchControlPanel(sccp);
			}
		});

		menuItem = new JRadioButtonMenuItem("已选课程");
		buttonGroup.add(menuItem);
		usecase.add(menuItem);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("查看已选课程");
				tablePanel.setTmd(selectedCourseTmd);
				switchControlPanel(sdccp);
			}
		});

		menuItem = new JRadioButtonMenuItem("已修课程");
		buttonGroup.add(menuItem);
		usecase.add(menuItem);

		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("查看已修课程");
				tablePanel.setTmd(finishCourseTmd);
			}
		});
		initLayout();
		switchControlPanel(sccp);
		initListener();
		this.menuBar.add(usecase);
	}

	private void initLayout() {
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
		this.add(rightPanel,
				new GBC(3, 0, 2, 3).setFill(GBC.BOTH).setIpad(100, 0)
						.setWeight(1, 1));

		this.setJMenuBar(menuBar);
	}

	private void initListener() {
		tablePanel.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = ((MyTable) e.getSource())
						.rowAtPoint(e.getPoint()); // 获得行位置
				int col = ((MyTable) e.getSource())
						.columnAtPoint(e.getPoint()); // 获得列位置
				tableselected=row;
				MyTableModel model=(MyTableModel) ((MyTable) e.getSource()).getModel();
				onItemSelect(model.getAdapter().itemAt(row));
			}
		});
		sccp.getComboBox().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				 if(e.getStateChange() == ItemEvent.SELECTED)
	             {
					 StudentBiz biz=StudentController.getInstance().getBiz();
	                 int  index=sccp.getComboBox().getSelectedIndex();
	                 List<Institute> institutes=sccp.getInstitutes();
	                 Institute institute=institutes.get(index);
	                 availableCourse=biz.getAvailableCourses(institute);
	                 courseListAdapter.attachData(availableCourse);
	                 System.out.println("学院id"+institute.getId());
	                 System.out.println("选中第"+index+"项");
	             }
			}
		});
		sdccp.getComboBox().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
	}
	
	protected void onItemSelect(Object item) {
		controlPanel.onItemChanged(item);
	}

	public void refreshData(){
		StudentBiz biz=StudentController.getInstance().getBiz();
		int  index=sccp.getComboBox().getSelectedIndex();
		List<Institute> institutes=sccp.getInstitutes();
		Institute institute=institutes.get(index);
		availableCourse=biz.getAvailableCourses(institute);
		selectedCourse=biz.getSelectedCourse();
		finishCourse=biz.getFinishCourse();
		
		courseListAdapter.attachData(availableCourse);
	    selectedCourseAdatpter.attachData(selectedCourse);
	    finishCourseAdapter.attachData(finishCourse);
	    
		System.out.println("已选课程"+selectedCourse);
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
