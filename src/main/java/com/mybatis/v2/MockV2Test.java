package com.mybatis.v2;

import com.mybatis.mapper.BusinessLogMapper;
import com.mybatis.v2.plugin.SelectPlugin;
import com.mybatis.v2.session.MyV2SqlSession;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * @author fujin
 * @version $Id: MockV2Test.java, v 0.1 2018-04-12 9:13 Exp $$
 */
public class MockV2Test {

    public static void main(String[] args) throws SQLException {
        MyV2SqlSession myV2SqlSession = new MyV2SqlSession(new SimpleV2Executor(), new MyV2Configuration(new SelectPlugin()));
        BusinessLogMapper userMapper = myV2SqlSession.getMapper(BusinessLogMapper.class);
        System.out.println(userMapper.selectById(2));

        final String sql = "UPDATE NOSUCHTABLE SET DATE_DISPATCHED = SYSDATE WHERE ID = ?";
        final int[] ids = new int[] { 100, 200 };
        final int[] rowsAffected = new int[] { 1, 2 };

        Connection connection = mock(Connection.class);
        DataSource dataSource = mock(DataSource.class);
        given(dataSource.getConnection()).willReturn(connection);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        given(preparedStatement.getConnection()).willReturn(connection);
        given(preparedStatement.executeBatch()).willReturn(rowsAffected);

//        DatabaseMetaData mockDatabaseMetaData = mock(DatabaseMetaData.class);
//        given(mockDatabaseMetaData.supportsBatchUpdates()).willReturn(true);
 //       given(connection.prepareStatement(sql)).willReturn(preparedStatement);
 //       given(connection.getMetaData()).willReturn(mockDatabaseMetaData);
    }
}


