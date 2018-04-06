package com.mybatis.v1;

/**
 * @author fujin
 * @version $Id: MqExecutor.java, v 0.1 2018-04-03 13:55 Exp $$
 */
public interface MqExecutor {

    <E> E query(String sql, Object parameter);
}