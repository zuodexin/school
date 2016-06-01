package com.zuodexin.ui.panel;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.zuodexin.po.Course;
import com.zuodexin.po.Institute;

public class SelectControlPanel extends ControlPanel{
	protected JLabel label=new JLabel();
	protected JComboBox comboBox=new JComboBox();
	protected JButton jbSelect=new JButton();
	
	public SelectControlPanel(JFrame frame,String txlabel,String txbutton) {
		super(frame);
		label.setText(txlabel);
		jbSelect.setText(txbutton);
	}

	@Override
	public void onItemChanged(Object item) {		
	}
}
