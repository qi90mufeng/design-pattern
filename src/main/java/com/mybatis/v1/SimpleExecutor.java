package com.mybatis.v1;

import com.mybatis.entity.BusinessLog;

import java.sql.*;

/**
 * @author fujin
 * @version $Id: SimpleExecutor.java, v 0.1 2018-04-03 13:56 Exp $$
 */
public class SimpleExecutor implements MyExecutor {

    public <E> E query(String sql, Object parameter){
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt;
            pstmt = conn.prepareStatement(String.format(sql, Integer.parseInt(String.valueOf(parameter))));
            ResultSet rs = pstmt.executeQuery();
            BusinessLog bl = new BusinessLog();
            while (rs.next()) {
                bl.setId(rs.getInt(1));
                bl.setUserId(rs.getLong(2));
                bl.setMethodCode(rs.getString(3));
                bl.setMethodName(rs.getString(4));
            }
            return (E) bl;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Connection getConnection() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sina?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "zEDG?fqul6oO";
        Connection conn = null;
        try {
            Class.forName(driver); //加载驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
