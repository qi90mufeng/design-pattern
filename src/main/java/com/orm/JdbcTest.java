package com.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class JdbcTest {

    public static void main(String[] args) {


    }

    public static List<?> select(Class<?> entityClass){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try(//建立连接
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sina");
                //创建语句并开始事务
                PreparedStatement preparedStatement = conn.prepareStatement("select id from xxxx");
                //执行语句集
                ResultSet rs = preparedStatement.executeQuery();){
                //加载驱动类

                //获取结果集
                while(rs.next()){
                    System.out.println();
                }
            }catch(Exception e){

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; //TODO 暂时未完成
    }
}
