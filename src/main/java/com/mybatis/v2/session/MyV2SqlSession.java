package com.mybatis.v2.session;

import com.mybatis.v2.MyV2Configuration;
import com.mybatis.v2.MyV2Executor;

/**
 * @author fujin
 * @version $Id: MyV2SqlSession.java, v 0.1 2018-04-03 13:24 Exp $$
 */
public class MyV2SqlSession {

    private MyV2Executor myV2Executor;

    private MyV2Configuration myV2Configuration;

    public MyV2SqlSession(MyV2Executor myV2Executor, MyV2Configuration myV2Configuration) {
        this.myV2Configuration = myV2Configuration;
        this.myV2Executor = myV2Configuration.newExecutor(myV2Executor);
    }

    /**
     * 动态代理，获取接口实例
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> clazz){
        return myV2Configuration.getMapper(clazz, this);
    }

    /**
     *
     * @param sql
     * @param parameter
     * @param <T>
     * @return
     */
    public <T> T selectOne(String sql, Object parameter){
        return myV2Executor.query(sql, parameter);
    }

    /**
     *
     * @param sql
     * @return
     */
    public int insert(String sql){
        return myV2Executor.insert(sql);
    }
}
