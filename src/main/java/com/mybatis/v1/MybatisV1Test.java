package com.mybatis.v1;

/**
 * @author fujin
 * @version $Id: MybatisV1Test.java, v 0.1 2018-04-03 13:26 Exp $$
 */
public class MybatisV1Test {

    public static void main(String[] args) {
        MqSqlSession  mqSqlSession = new MqSqlSession();
        BusinessLogMapper userMapper = mqSqlSession.getMapper(BusinessLogMapper.class);
        System.out.println(userMapper.selectByPrimaryId(1));
    }
}
