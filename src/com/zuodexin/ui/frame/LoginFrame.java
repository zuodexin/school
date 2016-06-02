package com.zuodexin.ui.frame;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.zuodexin.controller.GlobalController;
import com.zuodexin.strategy.AdminLoginStrategy;
import com.zuodexin.strategy.ProfessorLoginStrategy;
import com.zuodexin.strategy.StudentLoginStrategy;
import com.zuodexin.ui.panel.LoginFormPanel;


public class LoginFrame extends JFrame{
	LoginFormPanel studentFormPanel=new LoginFormPanel("学生登录");
	LoginFormPanel professorFormPanel=new LoginFormPanel("教授登录");
	LoginFormPanel adminFormPanel=new LoginFormPanel("管理者登录");
	JTabbedPane tab=new JTabbedPane(JTabbedPane.TOP);
	JPanel titlePanel=new JPanel();
	JLabel title=new JLabel("课程注册系统");
	public LoginFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		adminFormPanel.disableRegist();
		initStrategy();
		tab.add(studentFormPanel,"学生");
		tab.add(professorFormPanel,"教授");
		tab.add(adminFormPanel,"管理者");
		titlePanel.add(title);
		Container container=this.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(title,BorderLayout.NORTH);
		container.add(tab,BorderLayout.CENTER);
		this.setBounds(300, 200, 500, 400);
	}
	
	private void initStrategy(){
		studentFormPanel.setStrategy(new StudentLoginStrategy());
		professorFormPanel.setStrategy(new ProfessorLoginStrategy());
		adminFormPanel.setStrategy(new AdminLoginStrategy());
	}
}
