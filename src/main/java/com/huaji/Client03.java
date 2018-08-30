package com.huaji;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
import java.net.Socket;  
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;  
  
public class Client03 extends JFrame implements ActionListener{  
	private static final long serialVersionUID = 1L;
	private JTextField MineNum,langNum;
	private JButton certain;
	private JLabel lei,lie;
	JPanel panel=new JPanel();
	Socket s;
	public Client03() {
		// TODO Auto-generated constructor stub
		super("远程帮助你的小伙伴");
//		setLayout(new GridLayout(2,3));
		try {
			s = new Socket("192.168.162.2",8888);
			System.out.println("客户端IP:"+s.getLocalAddress()+"端口"+s.getPort());  
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		panel.add(lei=new JLabel("行数:"));
		panel.add(MineNum=new JTextField(10));
		panel.add(lie=new JLabel("列数:"));
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
    public static void main(String[] args) throws InterruptedException {  
        	new Client03();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==certain) {
			send();
//			setVisible(false);
			
		}
	}
	private void send() {
		// TODO Auto-generated method stub
		  try {  
	          
	            //构建IO流  
	            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));  
	              
	            	int a=Integer.parseInt(MineNum.getText().trim());//获得输入的行数
	            	int b=Integer.parseInt(langNum.getText().trim());//获得输入的列数
	                bw.write(a+","+b);  
	                bw.newLine();  
	                bw.flush();  
	        } catch (UnknownHostException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	}  
}  