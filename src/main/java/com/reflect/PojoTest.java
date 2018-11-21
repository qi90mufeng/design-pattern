package com.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * ////////////////////////////////////////////////////////////////////
 * //                          _ooOoo_                               //
 * //                         o8888888o                              //
 * //                         88" . "88                              //
 * //                         (| ^_^ |)                              //
 * //                         O\  =  /O                              //
 * //                      ____/`---'\____                           //
 * //                    .'  \\|     |//  `.                         //
 * //                   /  \\|||  :  |||//  \                        //
 * //                  /  _||||| -:- |||||-  \                       //
 * //                  |   | \\\  -  /// |   |                       //
 * //                  | \_|  ''\---/''  |   |                       //
 * //                  \  .-\__  `-`  ___/-. /                       //
 * //                ___`. .'  /--.--\  `. . ___                     //
 * //              ."" '<  `.___\_<|>_/___.'  >'"".                  //
 * //            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
 * //            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
 * //      ========`-.____`-.___\_____/___.-`____.-'========         //
 * //                           `=---='                              //
 * //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
 * //         佛祖保佑       永无BUG     永不修改                      //
 * ////////////////////////////////////////////////////////////////////
 *
 * @author fujin
 * @version v 0.1
 * @date 2018-11-20
 */
public class PojoTest {

    /**
     * 使用反射修改一个private修饰符的变量name
     */
    @Test
    public void test1() throws Exception {
        Pojo1 p = new Pojo1();
        // 查看被修改之前的值
        p.printName();
        // 反射获取字段, name成员变量
        Field nameField = p.getClass().getDeclaredField("name");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        nameField.setAccessible(true);
        // 使用反射进行赋值
        nameField.set(p, new StringBuilder("111"));
        // 打印查看被修改后的值
        p.printName();
    }

    /**
     * 使用反射修改一个final修饰符的变量name
     */
    @Test
    public void test2() throws Exception {
        Pojo2 p = new Pojo2();
        // 查看被修改之前的值
        p.printName();
        // 反射获取字段, name成员变量
        Field nameField = p.getClass().getDeclaredField("name");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        nameField.setAccessible(true);
        // 使用反射进行赋值
        nameField.set(p, new StringBuilder("111"));
        // 打印查看被修改后的值
        p.printName();
    }

    /**
     * 使用反射修改一个final修饰符的String类型变量name
     */
    @Test
    public static void test3() throws Exception {
        Pojo3 p = new Pojo3();
        // 查看被修改之前的值
        p.printName();
        // 反射获取字段, name成员变量
        Field nameField = p.getClass().getDeclaredField("name");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        nameField.setAccessible(true);
        // 使用反射进行赋值
        nameField.set(p, "111");
        // 打印查看被修改后的值
        p.printName();
        // 再使用反射再把name值取出来
        Object name = nameField.get(p);
        // 把取出来的name值进行打印
        System.out.println(name.toString());
    }

    /**
     * 使用反射修改一个final修饰符的String类型变量name, 同时防止字符串在编译时被处理为常量
     * 只要让name的值经过运行才能获得, 那么就不会被处理为常量
     */
    @Test
    public void test4() throws Exception {
        Pojo4 p = new Pojo4();
        // 查看被修改之前的值
        p.printName();
        // 反射获取字段, name成员变量
        Field nameField = p.getClass().getDeclaredField("name");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        nameField.setAccessible(true);
        // 使用反射进行赋值
        nameField.set(p, "111");
        // 打印查看被修改后的值
        p.printName();
    }

    /**
     * 使用反射修改一个final修饰符的String类型变量name, 同时防止字符串在编译时被处理为常量
     */
    @Test
    public void test5() throws Exception {
        Pojo5 p = new Pojo5();
        // 查看被修改之前的值
        p.printName();
        // 反射获取字段, name成员变量
        Field nameField = p.getClass().getDeclaredField("name");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        nameField.setAccessible(true);
        // 使用反射进行赋值
        nameField.set(p, "111");
        // 打印查看被修改后的值
        p.printName();
    }

    /**
     * 使用反射修改一个static修饰符的变量name
     */
    @Test
    public void test6() throws Exception {
        Pojo6 p = new Pojo6();
        // 查看被修改之前的值
        p.printName();
        // 反射获取字段, name成员变量
        Field nameField = p.getClass().getDeclaredField("name");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        nameField.setAccessible(true);
        // 使用反射进行赋值
        nameField.set(p, new StringBuilder("111"));
        // 打印查看被修改后的值
        p.printName();
    }

    /**
     * 使用反射修改final + static修饰符的变量name
     * 反射无法修改同时被static final修饰的变量
     * java.lang.IllegalAccessException: Can not set static final java.lang.StringBuilder field com.reflect.Pojo7.name to java.lang.StringBuilder
     */
    @Test
    public void test7() throws Exception {
        Pojo7 p = new Pojo7();
        // 查看被修改之前的值
        p.printName();
        // 反射获取字段, name成员变量
        Field nameField = p.getClass().getDeclaredField("name");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        nameField.setAccessible(true);
        // 使用反射进行赋值
        nameField.set(p, new StringBuilder("111"));
        // 打印查看被修改后的值
        p.printName();
    }
    /**
     * 使用反射修改final + static修饰符的变量name
     */
    @Test
    public void test71() throws Exception {
        Pojo7 p = new Pojo7();
        // 查看被修改之前的值
        p.printName();
        // 反射获取字段, name成员变量
        Field nameField = p.getClass().getDeclaredField("name");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        nameField.setAccessible(true);
        Field modifiers = nameField.getClass().getDeclaredField("modifiers");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        modifiers.setAccessible(true);
        //通过反射, 把nameField的final修饰符去掉
        modifiers.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);
        // 使用反射进行赋值
        nameField.set(p, new StringBuilder("111"));
        //把final修饰符加回来
        modifiers.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);
        // 打印查看被修改后的值
        p.printName();
    }

    /**
     * java.lang.IllegalAccessException: Can not set static final int field com.reflect.Pojo8.name to java.lang.Integer
     */
    @Test
    public void test8() throws Exception {
        Pojo8 p = new Pojo8();
        // 查看被修改之前的值
        p.printName();
        // 反射获取字段, name成员变量
        Field nameField = p.getClass().getDeclaredField("name");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        nameField.setAccessible(true);
        // 使用反射进行赋值
        nameField.set(p, 22);
        // 打印查看被修改后的值
        p.printName();
    }

    @Test
    public void test81() throws Exception {
        Pojo8 p = new Pojo8();
        // 查看被修改之前的值
        p.printName();
        // 反射获取字段, name成员变量
        Field nameField = p.getClass().getDeclaredField("name");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        nameField.setAccessible(true);
        Field modifiers = nameField.getClass().getDeclaredField("modifiers");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        modifiers.setAccessible(true);
        //通过反射, 把nameField的final修饰符去掉
        modifiers.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);
        // 使用反射进行赋值
        nameField.set(p, 111);
        //把final修饰符加回来
        modifiers.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);
        // 打印查看被修改后的值
        p.printName();
        // 再使用反射再把name值取出来
        Object name = nameField.get(p);
        // 把取出来的name值进行打印
        System.out.println(name.toString());
    }

    @Test
    public void test9() throws Exception {
        Pojo9 p = new Pojo9();
        // 查看被修改之前的值
        p.printName();
        // 反射获取字段, name成员变量
        Field nameField = p.getClass().getDeclaredField("name");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        nameField.setAccessible(true);
        Field modifiers = nameField.getClass().getDeclaredField("modifiers");
        // 由于name成员变量是private, 所以需要进行访问权限设定
        modifiers.setAccessible(true);
        //通过反射, 把nameField的final修饰符去掉
        modifiers.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);
        // 使用反射进行赋值
        nameField.set(p, 111);
        //把final修饰符加回来
        modifiers.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);
        // 打印查看被修改后的值
        p.printName();
    }

}
