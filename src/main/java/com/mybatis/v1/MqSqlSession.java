package com.mybatis.v1;

/**
 * @author fujin
 * @version $Id: MqSqlSession.java, v 0.1 2018-04-03 13:24 Exp $$
 */
public class MqSqlSession {

    private MqExecutor mqExecutor;

    public <T> T getMapper(Class<T> clazz){
        mqExecutor = new SimpleExecutor();
        return mqExecutor.query("select * from a_business_log where id=%d", 1);
    }
}
