package com.zuodexin.ui.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.zuodexin.biz.StateBiz;
import com.zuodexin.dao.StateDao;
import com.zuodexin.po.State;

public class AdminFrame extends BusinessFrame{
	JComboBox cbState=new JComboBox();
	JButton btnCommit=new JButton("<html><font color='red'>更改</font></html>");
	JLabel lbSelectCourse=new JLabel();
	JLabel lbTeachClass=new JLabel();
	JLabel lbGaveGrade=new JLabel();
	List<State> stateList;
	public AdminFrame(){
		super();
		initCm();
		initTxPanel();
		initListener();
		this.setLayout(new BorderLayout());
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel("选择状态"));
		panel.add(cbState);
		panel.add(btnCommit);
		JPanel txPanel=new JPanel();
		txPanel.add(new JLabel("选课："));
		txPanel.add(lbSelectCourse);
		txPanel.add(new JLabel("教课："));
		txPanel.add(lbTeachClass);
		txPanel.add(new JLabel("登成绩："));
		txPanel.add(lbGaveGrade);
		this.add(panel,BorderLayout.CENTER);
		this.add(txPanel,BorderLayout.NORTH);
	}
	private void initListener() {
		btnCommit.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index=cbState.getSelectedIndex();
				System.out.println("激活"+index+stateList.get(index).getName());
				StateBiz stateBiz=new StateBiz();
				stateBiz.activateState(stateList.get(index));
				initTxPanel();
			}
		});
		
	}
	private void initTxPanel(){
		StateBiz stateBiz=new StateBiz();
		State state= stateBiz.getActiveState();
		if(state.isCanSelectCourse()){
			lbSelectCourse.setText("允许");
		}
		else{
			lbSelectCourse.setText("不允许");
		}
		if(state.isCanTeachClass()){
			lbTeachClass.setText("允许");
		}
		else{
			lbTeachClass.setText("不允许");
		}
		if(state.isCanGaveGrade()){
			lbGaveGrade.setText("允许");
		}
		else{
			lbGaveGrade.setText("不允许");
		}
	}
	private void initCm(){
		StateDao stateDao=new StateDao();
		stateList=stateDao.findAll();
		int index=0;
		for(State s:stateList){
			if(s.isActive()) 
				index=stateList.indexOf(s);
			cbState.addItem(s.getName());
		}
		cbState.setSelectedIndex(index);
	}
}
