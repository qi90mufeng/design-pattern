package com.thread;

import java.util.concurrent.CyclicBarrier;

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
 * @version $Id: CarrTest.java, v 0.1 2018-08-31 Exp $$
 */
public class CyclicTest extends Thread {

    private static final int size = 20;
    private static volatile int count = 0;
    private final String name;
    static final CyclicBarrier cb = new CyclicBarrier(10,()-> System.out.println("一起降落"));

    private CyclicTest(String name){
        this.name = name;
    }
    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            CyclicTest ct = new CyclicTest("c" + i);
            ct.start();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "-->起飞");
            cb.await();
        } catch (Exception e) {
            //
        }
    }
}