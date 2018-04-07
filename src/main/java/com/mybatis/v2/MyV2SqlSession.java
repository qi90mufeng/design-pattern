package com.mybatis.v2;

import com.mybatis.v1.MyConfiguration;
import com.mybatis.v1.MyExecutor;

/**
 * @author fujin
 * @version $Id: MyV2SqlSession.java, v 0.1 2018-04-03 13:24 Exp $$
 */
public class MyV2SqlSession {

    private MyExecutor myExecutor;

    private MyV2Configuration myV2Configuration;

    public MyV2SqlSession(MyExecutor myExecutor, MyV2Configuration myV2Configuration) {
        this.myExecutor = myExecutor;
        this.myV2Configuration = myV2Configuration;
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
        return myExecutor.query(sql, parameter);
    }
}
