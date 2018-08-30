package com.huaji;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

public class Main extends JFrame implements ActionListener, MouseListener {
	/**
	 * 义建
	 */
	private static final long serialVersionUID = 1L;

	// 前期参数声明
	JMenuItem JmiNew, JmiSave, JmiOpen, JmiExit, Jmichuji, Jmizhongji, Jmigaoji, JmishowInFo, JmiZiding;

	Toolkit toolKit = Toolkit.getDefaultToolkit(); // 获取默认工具包。

	Clipboard clipboard = toolKit.getSystemClipboard();// 获取系统 Calibrate
														// 的一个实例，作为本机平台提供的剪贴板工具的接口。
	//两个图标
	ImageIcon icon = new ImageIcon("G:\\eclipse-workspace\\classTest_ThunderGame\\mine.png");
	ImageIcon icon1 = new ImageIcon("G:\\eclipse-workspace\\classTest_ThunderGame\\flag.png");
	private static int NUM = 1;// 这个NUM是雷数，可以编写一个程序来改变
	// private static final int SNUM = 9;// 这个SNUM是扫雷的格数，可以编写一个程序来改变
	private JButton[][] jb;
	private int[][] map;
	boolean[][] flags;
	boolean[][] flag;
	int coutTime;

	// 声明connection对象
	Connection con;
	// 驱动程序名
	String driver = "com.mysql.jdbc.Driver";
	// url:指向要访问的数据库名
	String url = "jdbc:mysql://localhost:3306/xxx";
	// mysql配置的用户名
	String user = "xxx";
	// 密码
	String password = "xxx";

	public Main(int SNUM, int Mines) {// 主要界面构造函数
		setTitle("扫雷");

		// 初始雷数量
		NUM = Mines;

		JMenuBar greenBar = new JMenuBar();// 菜单容器
		greenBar.setOpaque(true);
		greenBar.setBackground(new Color(250, 250, 250));
		greenBar.setPreferredSize(new Dimension(800, 28));
		greenBar.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));

		// 菜单
		JMenu fileMenu1 = new JMenu("游戏");
		JMenu fileMenu2 = new JMenu("难度");
		JMenu fileMenu3 = new JMenu("帮助:");
		greenBar.add(fileMenu1);
		greenBar.add(fileMenu2);
		greenBar.add(JmishowInFo = fileMenu3);
		fileMenu1.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		fileMenu2.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		fileMenu3.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		// 菜单项
		fileMenu1.add(JmiNew = new JMenuItem(" 新游戏 "));
		fileMenu1.add(JmiSave = new JMenuItem(" 排行版 "));
		fileMenu1.add(JmiZiding = new JMenuItem(" 自定义 "));
		fileMenu1.addSeparator();
		fileMenu1.add(JmiExit = new JMenuItem(" 退出 "));
		fileMenu2.add(Jmichuji = new JMenuItem(" 初级 "));
		fileMenu2.add(Jmizhongji = new JMenuItem(" 中级 "));
		fileMenu2.add(Jmigaoji = new JMenuItem(" 高级 "));
		fileMenu3.add(JmishowInFo = new JMenuItem(" 开发者信息 "));
		JmiNew.addActionListener(this);
		JmiExit.addActionListener(this);
		JmiSave.addActionListener(this);
		JmishowInFo.addActionListener(this);
		Jmichuji.addActionListener(this);
		Jmizhongji.addActionListener(this);
		Jmigaoji.addActionListener(this);
		JmiZiding.addActionListener(this);
		JmiZiding.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		JmishowInFo.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		JmiNew.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		JmiSave.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		JmiExit.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		Jmichuji.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		Jmizhongji.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		Jmigaoji.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		setJMenuBar(greenBar);
		Image icon = Toolkit.getDefaultToolkit().getImage("G:\\eclipse-workspace\\classTest_ThunderGame\\mine.png");
		setIconImage(icon);
		setLayout(new GridLayout(SNUM, SNUM));
		jb = new JButton[SNUM][SNUM];
		map = new int[SNUM][SNUM]; // 将按钮映射到数组中
		flags = new boolean[map.length][map[0].length];// 保存点开记录表
		flag = new boolean[map.length][map[0].length];// 保存点开记录表
		int count = 0;

		// 布雷
		while (count < NUM) {
			int i = (int) (Math.random() * map.length);// hang
			int j = (int) (Math.random() * map[0].length);// lie
			if (map[i][j] != '*') {
				map[i][j] = '*';
				count++;

			}
		}
		for (int i = 0; i < SNUM; i++) {
			for (int j = 0; j < SNUM; j++) {
				jb[i][j] = new JButton();
				jb[i][j].setName(i + "_" + j);
				jb[i][j].setBackground(new Color(220, 220, 220));

				jb[i][j].setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 10));
				jb[i][j].addActionListener(this);
				jb[i][j].addMouseListener(this);// 加入mouse监听
				add(jb[i][j]);

			}

		}

		// 计时器
		JLabel ststus = new JLabel();
		JLabel Times = new JLabel();
		JLabel miao = new JLabel();
		add(ststus);
		add(Times);
		Times.setText(" 0  ");
		miao.setText("  秒");
		setTimer(Times);
		coutTime = 0;
		ststus.setText("                                              时间：");
		greenBar.add(ststus);
		greenBar.add(Times, RIGHT_ALIGNMENT);
		greenBar.add(miao, RIGHT_ALIGNMENT);
		Times.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		ststus.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		miao.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		setSize(700, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 加入这一行

		
		
		
        ServerSocket ss;
		try {  //多人扫雷使用，可注释次此代码
			ss = new ServerSocket(8888);
			System.out.println("服务器已启动");  
	        Socket s = ss.accept(); 
	        //构建IO流  
            while(true){  
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));  
                String mess = br.readLine();  
//                BufferedWriter ps = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));  
                int i0 = Integer.parseInt(mess.split(",")[0], 10);
                int i1 = Integer.parseInt(mess.split(",")[1], 10);
                showTheClick(i0, i1);
            }  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
		
		

	}

	private void setTimer(JLabel time) {// 时间监听
		final JLabel varTime = time;

		Timer timeAction = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				coutTime++;
				varTime.setText("" + coutTime);
			}
		});
		timeAction.start();
	}

	private void showTheClick(int x, int y) {// 点击事件实现
		if (map[x][y] == '*') {

			jb[x][y].setIcon(icon);
			showMines();
		} else {
			int count1 = 0;
			for (int a = x - 1; a <= x + 1; a++) {
				for (int b = y - 1; b <= y + 1; b++) {
					if (!(a < 0 || b < 0 || b >= map[0].length || a >= map.length) && map[a][b] == '*')
						count1++;
				}
			}
			flags[x][y] = true;
			if (count1 == 0) {
				jb[x][y].setBackground(Color.white);
			} else {
				jb[x][y].setText(count1 + "");
				jb[x][y].setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 20));
				jb[x][y].setBackground(Color.white);
			}

			if (count1 == 0) {
				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {
						if (!(i < 0 || j < 0 || i >= map.length || j >= map[0].length)) {
							if (!(i == x && j == y) && flags[i][j] == false) {
								showTheClick(i, j);//循环遍历
							} else {
								// 防止重复访问
							}

						}

					}
				}
			}
		}
	}

	private void showMines() {// 显示所有雷
		// TODO Auto-generated method stub
		for (int i = 0; i < map.length; i++) {// 显雷
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == '*') {
					jb[i][j].setIcon(icon);
					//

				}
			}
		}

		// 结束游戏
		int b = JOptionPane.showOptionDialog(null, "哎呀，炸了炸了，新游戏？", "确认框", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (b == 1) {
			System.exit(0);

		} else {
			setVisible(false);
			new Main(map.length,NUM);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {// 事件监听处理
		// TODO Auto-generated method stub
		if (e.getSource() == JmiNew) {
			setVisible(false);
			new Main(map.length,NUM);
		} else if (e.getSource() == JmiSave) {

			showRange();
		} else if (e.getSource() == JmiExit) {
			System.exit(0);
		} else if (e.getSource() == JmiZiding) {
			new SelfMines();
		} else if (e.getSource() == Jmichuji) {
			setVisible(false);
			new Main(5,3);
		} else if (e.getSource() == JmishowInFo) {
			new MyInfo();
		} else if (e.getSource() == Jmizhongji) {
			setVisible(false);
			new Main(10,10);
		} else if (e.getSource() == Jmigaoji) {
			setVisible(false);
			new Main(20,60);
		} else {
			Object obj = e.getSource();
			int x, y;
			String[] strM = ((JButton) obj).getName().split("_");
			x = Integer.parseInt(strM[0]);
			y = Integer.parseInt(strM[1]);

			showTheClick(x, y);

			checkSuccess();// 检查是否游戏结束
		}

	}

	private void showRange() {// 显示排行榜
		new Shiyan13(map.length);

	}

	private void checkSuccess() {
		// TODO Auto-generated method stub
		int count = map.length * map[0].length;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (flags[i][j] == true)
					count--;
			}
		}
		if (count == NUM) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");//表唯一标示uuid

			// 链接数据库，存储时间数据
			try {

				Class.forName(driver);
				con = (Connection) DriverManager.getConnection(url, user, password);
				String sql;
				if (!con.isClosed()) {
					// ta.setText("");
					System.out.println("连接数据库成功");
					// 创建对象
					Statement statement = (Statement) con.createStatement();
					//

					if (map.length == 10) {
						// //要执行的sql语句
						sql = "insert into middlerange(userId,userTime) values(\"" + uuid + "\"," + coutTime + ");";
						statement.executeUpdate(sql);
						con.close();
					} else if (map.length == 5) {
						sql = "insert into rang(userid,userTime) values(\"" + uuid + "\"," + coutTime + ");";
						statement.executeUpdate(sql);
						con.close();

					} else if (map.length == 20) {
						sql = "insert into toprange(userId,userTime) values(\"" + uuid + "\"," + coutTime + ");";
						statement.executeUpdate(sql);
						con.close();
					}else{
						
					}

				}

			} catch (ClassNotFoundException e) {

				// 数据库驱动类异常处理
				System.out.println("error");
				e.printStackTrace();

			} catch (SQLException e) {
				// System.out.println(e);
				System.err.println("找不到数据");
				// int i=JOptionPane.showConfirmDialog(null, "你输入的sql语句有误",
				// "找不到",JOptionPane.YES_NO_OPTION);
			} catch (Exception e) {

				e.printStackTrace();

			} finally {
				System.out.println("数据库获取数据成功！");
			}

			int i = JOptionPane.showOptionDialog(null, "恭喜你过关了，是否继续？", "确认框", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, null, null);
			// ststus.setText("hello"+i);
			if (i == 1) {
				System.exit(0);

			} else {
				setVisible(false);
				new Main(map.length,NUM);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int c = e.getButton();
		if (c == MouseEvent.BUTTON3) {
			Object obj1 = e.getSource();
			int x, y;

			String[] strM = ((JButton) obj1).getName().split("_");
			x = Integer.parseInt(strM[0]);
			y = Integer.parseInt(strM[1]);
			if (flag[x][y] == false && flags[x][y] == false) {//插旗子
				jb[x][y].setIcon(icon1);
				flag[x][y] = true;
			} else {
				jb[x][y].setIcon(null);
				flag[x][y] = false;

			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
