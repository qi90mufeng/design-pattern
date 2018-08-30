package com.huaji;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelfMines extends JFrame implements ActionListener {
	/**
	 * 义建12.27
	 */
	private static final long serialVersionUID = 1L;
	private JTextField MineNum,langNum;
	private JButton certain;
	private JLabel lei,lie;
	JPanel panel=new JPanel();
	
	public SelfMines() {
		super("自定义游戏");
//		setLayout(new GridLayout(2,3));
		panel.add(lei=new JLabel("雷数:"));
		panel.add(MineNum=new JTextField(10));
		panel.add(lie=new JLabel("行列数:"));
		panel.add(langNum =new JTextField(10));
		panel.add(certain =new JButton("确定"));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		certain.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		lei.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		lie.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		MineNum.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		langNum.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		certain.addActionListener(this);
		//窗口
		add(panel,BorderLayout.CENTER);
		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}
public static void main(String[] args) {
	new SelfMines();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource()==certain) {
		outMine();
		setVisible(false);
		
	}
}
private void outMine() {
	// TODO Auto-generated method stub
	int num=Integer.parseInt(MineNum.getText().trim());//获得输入的雷数
	int num1=Integer.parseInt(langNum.getText().trim());//获得输入的行列数
	new Main(num1,num );
}
}
