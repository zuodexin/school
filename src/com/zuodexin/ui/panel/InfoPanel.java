package com.zuodexin.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel{
	JLabel title=new JLabel("信息面板");
	JLabel content=new JLabel("内容");
	public InfoPanel(){
		this.setBackground(Color.PINK);
		this.setLayout(new BorderLayout());
		this.add(title,BorderLayout.NORTH);
		this.add(content,BorderLayout.CENTER);
	}
	public void setTitle(String str){
		this.title.setText(str);
	}
	public void setInfo(String info){
		this.content.setText(info);
	}
}
