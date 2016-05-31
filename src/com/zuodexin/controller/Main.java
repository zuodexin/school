package com.zuodexin.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.zuodexin.util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		GlobalController.getInstance().run();
	}
}
