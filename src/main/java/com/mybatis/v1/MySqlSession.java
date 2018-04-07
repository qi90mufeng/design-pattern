package com.mybatis.v1;

/**
 * @author fujin
 * @version $Id: MySqlSession.java, v 0.1 2018-04-03 13:24 Exp $$
 */
public class MySqlSession {

    private MyExecutor myExecutor;

    private MyConfiguration myConfiguration;

    public MySqlSession(MyExecutor myExecutor, MyConfiguration myConfiguration) {
        this.myExecutor = myExecutor;
        this.myConfiguration = myConfiguration;
    }

    public <T> T getMapper(Class<T> clazz){
        return myConfiguration.getMapper(clazz, this);
    }

    /**
     *
     * @param sql
     * @param parameter
     * @param <T>
     * @return
     */
    public <T> T selectOne(String sql, Object parameter){
        return myExecutor.query(sql, parameter);
    }
}
