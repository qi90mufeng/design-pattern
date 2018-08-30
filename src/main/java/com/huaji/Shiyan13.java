package com.huaji;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.ResultSetMetaData;
//import com.mysql.jdbc.Statement;

public class Shiyan13 extends JFrame implements ActionListener{
	/**
	 * 义建1.0
	 */
	private static final long serialVersionUID = 1L;
	JTextArea ta = new JTextArea(30,80);
	JScrollPane pane = new JScrollPane(ta);
	JPanel pannel=new JPanel();
	JPanel pannel2=new JPanel();
	JLabel tlJLabel=new JLabel("排行榜");
	int b;
//	bgp=new BackgroundPanel((new ImageIcon("G:\\eclipse-workspace\\classTest_ThunderGame\\backgtoud.jpg")).getImage());  
	// 开始
	public Shiyan13(int a ){
		super("排行榜");
		b=a;
		if(a==10){
			tlJLabel.setText("中级排行榜");
		}else if(a==5){
			tlJLabel.setText("初级排行榜");
			 
		}else {
			tlJLabel.setText("高级排行榜");
			
		}
		pannel.add(pane,BorderLayout.PAGE_START);
		pannel.setBackground(Color.lightGray);
		pannel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
	
		ta.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,16));
		pannel2.add(tlJLabel);
		add(pannel,BorderLayout.CENTER);
		add(pannel2,BorderLayout.PAGE_END);
		setSize(1200, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		doSearch();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new Shiyan13(5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	
	@SuppressWarnings("deprecation")
	private void doSearch() {
		
		// TODO Auto-generated method stub
		//声明connection对象
				Connection con;
				//驱动程序名
				String driver="com.mysql.jdbc.Driver";
				//url:指向要访问的数据库名
				String url="jdbc:mysql://localhost:3306/xxx";
				//mysql配置的用户名
				String user ="xxx";
				//密码
				String password="xxx";
				//遍历结果集
				try{
					Class.forName(driver);
					con=(Connection) DriverManager.getConnection(url, user, password);
					
				String sql = null ;
					if(!con.isClosed()){
						ta.setText("");
						System.out.println("连接数据库成功");
						//创建对象
						Statement statement=(Statement) con.createStatement();
						//要执行的sql语句
						if(b==10){
							sql="select * from middlerange order by userTime ;";
						}else if(b==5){
							tlJLabel.setText("初级排行榜");
							sql="select * from rang order by userTime ;";
							 
						}else if(b==20){
							tlJLabel.setText("高级排行榜");
							sql="select * from toprange order by userTime ;";
							
						}else{
							
							tlJLabel.setText("自定义不设置排行榜");
							
						}
						ResultSet rs=statement.executeQuery(sql);
						
						ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
						int count=1;
						int xuhao=1;

						String[] name=new String[count];
						ta.append("高分榜"+"\t"+"用时");
						ta.append("\n");
						while(rs.next()){
							//获取name
							for(int i=0;i<count;i++){
								ta.append(xuhao+"\t"+rs.getString("userTime")+"\t");
							}
							xuhao++;
							ta.append("\n");
						}
						rs.close();
						con.close();
						
						
					}
				}catch (ClassNotFoundException e) {
					
					//数据库驱动类异常处理
					System.out.println("error");
					e.printStackTrace();
					
				}catch (SQLException e) {

					System.err.println("找不到数据");
					int i=JOptionPane.showConfirmDialog(null, "你输入的sql语句有误", "找不到",JOptionPane.YES_NO_OPTION);
				}catch(Exception e){
					
					e.printStackTrace();
					
				}finally {
					System.out.println("数据库获取数据成功！");
				}
				
	}

	
	
	
	
}
