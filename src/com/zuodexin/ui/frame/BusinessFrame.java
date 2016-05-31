package com.zuodexin.ui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.zuodexin.ui.layout.GBC;
import com.zuodexin.ui.panel.ControlPanel;
import com.zuodexin.ui.panel.InfoPanel;
import com.zuodexin.ui.panel.TablePanel;

public abstract class BusinessFrame extends JFrame{
	String[] studentTitle={"id","学号","姓名"};
	
	ControlPanel controlPanel;
	InfoPanel infoPanel=new InfoPanel();
	//根据不同的业务有不同的table panel
	TablePanel tablePanel;
	JMenuBar menuBar=new JMenuBar();
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	
	public BusinessFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setBounds(300, 200, 500, 400);
	}
}
