package com.design.pattern.factory.factory;

/**
 * @author fujin
 * @version $Id: FactoryTest.java, v 0.1 2018-04-02 16:17 Exp $$
 */
public class FactoryTest {

    public static void main(String[] args) {
        //工厂模式  有很多个工厂   多个入口
        //工厂标准化生产  每一个配件都有专门的公司进行制作

        KeyBoardFactory factory = new KeyBoardFactory();
        System.out.println(factory.getKeyBoard().getName());



    }
}
