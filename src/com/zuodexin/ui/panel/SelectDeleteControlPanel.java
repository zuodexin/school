package com.zuodexin.ui.panel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SelectDeleteControlPanel extends ControlPanel{
	protected JLabel label=new JLabel();
	protected JComboBox comboBox=new JComboBox();
	protected JButton jbSelect=new JButton();
	protected JButton jbDelete=new JButton();
	
	public SelectDeleteControlPanel(JFrame frame,String txlabel,String txSelect,String txDelete) {
		super(frame);
		label.setText(txlabel);
		jbSelect.setText(txSelect);
		jbDelete.setText(txDelete);
	}

	@Override
	public void onItemChanged(Object item) {
		
	}

}
