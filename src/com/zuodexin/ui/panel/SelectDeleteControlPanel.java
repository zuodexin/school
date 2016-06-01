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

}
