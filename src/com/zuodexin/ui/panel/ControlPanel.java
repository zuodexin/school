package com.zuodexin.ui.panel;

import java.awt.Color;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class ControlPanel extends JPanel{
	JFrame parentFrame;
	public ControlPanel(JFrame frame){
		parentFrame=frame;
		this.setBackground(Color.green);
	}
	abstract public void onItemChanged(Object item);
	public JFrame getParentFrame() {
		return parentFrame;
	}
	public void setParentFrame(JFrame parentFrame) {
		this.parentFrame = parentFrame;
	}
}
