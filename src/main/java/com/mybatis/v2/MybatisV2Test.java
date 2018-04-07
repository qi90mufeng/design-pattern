package com.mybatis.v2;

import com.mybatis.mapper.BusinessLogMapper;
import com.mybatis.v1.MyConfiguration;
import com.mybatis.v1.MySqlSession;
import com.mybatis.v1.SimpleExecutor;

/**
 * @author fujin
 * @version $Id: MybatisV2Test.java, v 0.1 2018-04-06 13:26 Exp $$
 */
public class MybatisV2Test {

    /**
     * 1、Configuration 获取xml配置
     * 2、SqlSession  会话，对外入口
     * 3、Executor 执行器，封装jdbc操作
     *
     * @param args
     */
    public static void main(String[] args) {
        MyV2SqlSession  myV2SqlSession = new MyV2SqlSession(new SimpleExecutor(), new MyV2Configuration());
        BusinessLogMapper userMapper = myV2SqlSession.getMapper(BusinessLogMapper.class);
        System.out.println(userMapper.selectById(5));
    }
}
