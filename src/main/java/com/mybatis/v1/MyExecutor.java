package com.mybatis.v1;

/**
 * @author fujin
 * @version $Id: MyExecutor.java, v 0.1 2018-04-03 13:55 Exp $$
 */
public interface MyExecutor {

    <E> E query(String sql, Object parameter);

    int insert(String sql);
}