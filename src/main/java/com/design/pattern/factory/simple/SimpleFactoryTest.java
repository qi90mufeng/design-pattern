package com.design.pattern.factory.simple;

/**
 * @author fujin
 * @version $Id: SimpleFactoryTest.java, v 0.1 2018-04-02 16:13 Exp $$
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        //简单工厂模式   小作坊
        SimpleFactory factory = new SimpleFactory();
        System.out.println(factory.getDevice("mouse").getName()); //打印一句话
        System.out.println(factory.getDevice("aaa").getName());  //会抛出不支持该设备

    }
}
