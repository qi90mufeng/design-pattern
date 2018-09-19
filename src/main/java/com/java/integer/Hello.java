/**
 * sinafenqi.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.java.integer;

import java.lang.reflect.Field;

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
 * @version $Id: Hello.java, v 0.1 2018-09-19 Exp $$
 */
public class Hello {

    public static void main(String[] args) {
        Integer a = new Integer(1);
        change(a);
        System.out.println(a);


        String b = "bb";
        change(b);
        System.out.println(b);
    }

    public static void change(Integer integer) {
        try {
            Field field = integer.getClass().getDeclaredField("value");
            field.setAccessible(true);
            field.set(integer,2);
        } catch (Exception e) {
            //
        }
    }

    public static void change(String str){
        try {
            Field field = str.getClass().getDeclaredField("value");
            field.setAccessible(true);
            field.set(str,new char[]{'b','b','b'});
        } catch (Exception e) {
            //
        }
    }

}