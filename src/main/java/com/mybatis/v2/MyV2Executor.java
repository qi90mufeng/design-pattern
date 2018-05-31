package com.mybatis.v2;

/**
 * @author fujin
 * @version $Id: MyV2Executor.java, v 0.1 2018-04-11 10:55 Exp $$
 */
public interface MyV2Executor {

    <E> E query(String sql, Object parameter);

    int insert(String sql);
}