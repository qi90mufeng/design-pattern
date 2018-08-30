package com.huaji;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyInfo extends JFrame {
	/**
	 * 义建
	 */
	private static final long serialVersionUID = 1L;

	public MyInfo() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame("个人页");
		JLabel label = new JLabel("义建出品1.0", SwingConstants.CENTER);
		frame.setSize(300, 300);
		frame.add(label);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

}
