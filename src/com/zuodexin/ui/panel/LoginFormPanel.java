package com.zuodexin.ui.panel;

import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.zuodexin.biz.AuthBiz;
import com.zuodexin.controller.GlobalController;
import com.zuodexin.strategy.LoginStrategy;
import com.zuodexin.ui.layout.GBC;

public class LoginFormPanel extends JPanel {
	JLabel jlTitle=new JLabel();
	JTextField jtfUsername=new JTextField();
	JPasswordField jtfPassword=new JPasswordField();
	JButton jbSubmit=new JButton("登录");
	JButton jbRegsit=new JButton("注册");
	LoginStrategy strategy;
	
	public LoginFormPanel(String text){
		setTitle(text);
		
		this.setLayout(new GridBagLayout());
//		jlTitle.setBorder(BorderFactory.createEtchedBorder());
		this.add(jlTitle,new GBC(1, 0, 3, 1).setFill(GBC.BOTH)
				.setInsets(0,70,0,70).setWeight(100, 10));
		this.add(jtfUsername,new GBC(0,1,5,1).setFill(GBC.BOTH)
				.setInsets(20,70,10,70).setWeight(100, 10));
		this.add(jtfPassword,new GBC(0,2,5,1).setFill(GBC.BOTH)
				.setInsets(10,70,20,70).setWeight(100, 10));
		this.add(jbRegsit,new GBC(0,3,2,1).setFill(GBC.BOTH)
				.setInsets(20,70,20,10).setWeight(100, 10));
		this.add(jbSubmit,new GBC(2,3,3,1).setFill(GBC.BOTH)
				.setInsets(20,0,20,70).setWeight(100, 10));
		jbSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtfUsername.getText().equals("")
						||String.valueOf(jtfPassword.getPassword()).equals(""))
					return;
				GlobalController.getInstance().Login(strategy,jtfUsername.getText()
						, String.valueOf(jtfPassword.getPassword()));
			}
		});
	}
	public void setStrategy(LoginStrategy strategy) {
		this.strategy = strategy;
	}
	public void setTitle(String text){
		jlTitle.setText(text);
	}
	public void disableRegist(){
		this.jbRegsit.setEnabled(false);
	}
}
