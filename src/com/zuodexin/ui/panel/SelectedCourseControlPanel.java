package com.zuodexin.ui.panel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

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
import com.zuodexin.po.JionClass;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.SelectCourse;
import com.zuodexin.ui.frame.StudentFrame;

public class SelectedCourseControlPanel extends ControlPanel{
	JLabel label=new JLabel("选择班级");
	JComboBox comboBox=new JComboBox();
	JButton jbSelect=new JButton("更改");
	JButton jbDelete=new JButton("删除");
	SelectCourse selectCourse;
	List<Schoolclass> classList=new ArrayList<Schoolclass>();
	public SelectedCourseControlPanel(JFrame frame){
		super(frame);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		jbDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				if(selectCourse==null) return;
				StudentBiz biz=StudentController.getInstance().getBiz();
				biz.dropCourse(selectCourse.getCourse());
				JOptionPane.showMessageDialog(null, 
						"取消成功", "取消课程", JOptionPane.PLAIN_MESSAGE); 
				((StudentFrame) parentFrame).refreshData();
			}
		});
		jbSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectCourse==null) return;
				StudentBiz biz=StudentController.getInstance().getBiz();
				Course course=selectCourse.getCourse();
				int index=comboBox.getSelectedIndex();
				Schoolclass schoolclass=classList.get(index);
				biz.changeClass(course, schoolclass);
				JOptionPane.showMessageDialog(null, 
						"修改成功", "更改班级", JOptionPane.PLAIN_MESSAGE); 
				((StudentFrame) parentFrame).refreshData();
			}
		});
		this.add(label);
		this.add(comboBox);
		this.add(jbSelect);
		this.add(jbDelete);
	}
	
	public void setSelectCourse(SelectCourse selectCourse) {
		Course course=selectCourse.getCourse();
		StudentBiz biz=StudentController.getInstance().getBiz();
		JionClass jionClass=biz.getCourseClass(course);
		classList=biz.getCourseClassList(course);
		comboBox.removeAllItems();
		for(Schoolclass s:classList){
			comboBox.addItem(s.getInfo());
		}
		this.selectCourse = selectCourse;
		this.revalidate();
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

	public JButton getJbSelect() {
		return jbSelect;
	}

	public void setJbSelect(JButton jbSelect) {
		this.jbSelect = jbSelect;
	}

	public JButton getJbDelete() {
		return jbDelete;
	}

	public void setJbDelete(JButton jbDelete) {
		this.jbDelete = jbDelete;
	}

	public List<Schoolclass> getClassList() {
		return classList;
	}

	public void setClassList(List<Schoolclass> classList) {
		this.classList = classList;
	}

	public SelectCourse getSelectCourse() {
		return selectCourse;
	}

	@Override
	public void onItemChanged(Object item) {
		this.setSelectCourse((SelectCourse) item);
		
	}	
}
