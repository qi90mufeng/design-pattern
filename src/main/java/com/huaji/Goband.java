package com.huaji;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Goband extends JFrame implements ActionListener {

	/**
	 * 义建
	 */
	private static final long serialVersionUID = 1L;

	Dimension demission= new Dimension(1000, 600);
	public Goband() {
		super("五子棋");


		setLayout(null);
		// 背景图片
		ImageIcon icon = new ImageIcon("G:\\eclipse-workspace\\classTest_ThunderGame\\backgroud1.jpg");
		ImageIcon icon1 = new ImageIcon("G:\\eclipse-workspace\\classTest_ThunderGame\\Gogame.jpg");
		// 设置主界面属性
		
		
        //将图片放入label中  
        JLabel label=new JLabel(icon);  
        JLabel GameImageContainer=new JLabel(icon1);  
          
        //设置label的大小  
        label.setBounds(0,0,1000,800);  
        GameImageContainer.setBounds(100, 500, 400, 400);
        GameImageContainer.setLocation(100, 500);
          
        JFrame frame=new JFrame();  
          
        //获取窗口的第二层，将label放入  
        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));  
              
        //获取frame的顶层容器,并设置为透明  
        JPanel j=(JPanel)frame.getContentPane();  
        j.setOpaque(false);  
  
        JPanel panel=new JPanel();  
        JPanel panel1=new JPanel();  
        panel1.setBounds(0, 0, 200, 200);

        panel1.add(GameImageContainer);
        //必须设置为透明的。否则看不到图片  
        panel.setOpaque(false);  
        panel1.setOpaque(false);  
        
        frame.add(panel);  
        frame.add(panel1);  
        frame.setSize(demission);  
        frame.setVisible(true);  
  
  
  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Goband();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
