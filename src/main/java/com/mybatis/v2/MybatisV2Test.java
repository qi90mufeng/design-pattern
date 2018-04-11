package com.mybatis.v2;

import com.mybatis.mapper.BusinessLogMapper;
import com.mybatis.v2.plugin.InsertPlugin;
import com.mybatis.v2.plugin.SelectPlugin;

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
        //select();
        insert();
    }

    private static void select(){
        MyV2SqlSession  myV2SqlSession = new MyV2SqlSession(new SimpleV2Executor(), new MyV2Configuration(new SelectPlugin()));
        BusinessLogMapper userMapper = myV2SqlSession.getMapper(BusinessLogMapper.class);
        System.out.println(userMapper.selectById(2));
    }

    private static void insert(){
        MyV2SqlSession  myV2SqlSession = new MyV2SqlSession(new SimpleV2Executor(), new MyV2Configuration(new InsertPlugin()));
        BusinessLogMapper userMapper = myV2SqlSession.getMapper(BusinessLogMapper.class);
        int rs =  userMapper.insertRecord();
        if (rs > 0){
            System.out.println("------insert success-------");
        }else{
            System.out.println("------insert failure-------");
        }
    }
}
