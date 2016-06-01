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
}
