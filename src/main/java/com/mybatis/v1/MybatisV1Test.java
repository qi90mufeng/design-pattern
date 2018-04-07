package com.mybatis.v1;

import com.mybatis.mapper.BusinessLogMapper;

/**
 * @author fujin
 * @version $Id: MybatisV1Test.java, v 0.1 2018-04-03 13:26 Exp $$
 */
public class MybatisV1Test {

    /**
     * 1、Configuration 获取xml配置
     * 2、SqlSession  会话，对外入口
     * 3、Executor 执行器，封装jdbc操作
     *
     * @param args
     */
    public static void main(String[] args) {
        MySqlSession  mqSqlSession = new MySqlSession(new SimpleExecutor(), new MyConfiguration());
        BusinessLogMapper userMapper = mqSqlSession.getMapper(BusinessLogMapper.class);
        System.out.println(userMapper.selectByPrimaryId(5));
    }
}
