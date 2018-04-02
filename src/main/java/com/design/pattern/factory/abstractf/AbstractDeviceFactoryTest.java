package com.design.pattern.factory.abstractf;

/**
 * @author fujin
 * @version $Id: AbstractDeviceFactoryTest.java, v 0.1 2018-04-02 16:23 Exp $$
 */
public class AbstractDeviceFactoryTest {

    public static void main(String[] args) {
        //流水线   抽象工厂模式   只需要一个总入口就可以
        //用户只需要选择方法，不需要知道具体的实现，拿来用即可
        DeviceFactory factory = new DeviceFactory();

        System.out.println(factory.getMouse().getName());
    }
}
