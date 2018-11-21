package com.queue;

import java.util.ArrayList;
import java.util.List;

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
 * 有阻塞的安全队列
 *
 * @author fujin
 * @version $Id: BlockingQueue.java, v 0.1 2018-09-05 Exp $$
 */
public class BlockingQueue {
    //队列的实现
    private List<String> list = new ArrayList<>();
    private int maxsize;
    private Object lock = new Object();
    //Collections.synchronizedList(new ArrayList<>());

    public BlockingQueue(int maxsize) {
        this.maxsize = maxsize;
        System.out.println("线程" + Thread.currentThread().getName() + "，队列初始化完成");
    }

    public void put(String element){
        synchronized (lock){
            try {
                if (this.list.size() == maxsize){
                    System.out.println("线程" + Thread.currentThread().getName() + "已经满了，put方法进入等待中...");
                    lock.wait();
                }
                this.list.add(element);
                System.out.println("线程" + Thread.currentThread().getName() + "向队列中添加了元素..." + element);

                lock.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void get(){
        synchronized (lock){
            try {
                if (this.list.size() == 0){
                    System.out.println("线程" + Thread.currentThread().getName() + "空了，get方法进入等待中...");
                    lock.wait();
                }
                String result = list.get(0);
                list.remove(0);
                System.out.println("线程" + Thread.currentThread().getName() + "在队列中取到了元素：" + result);

                lock.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        BlockingQueue bq = new BlockingQueue(5);
        new Thread(()->{
            bq.put("1");
            bq.put("2");
            bq.put("3");
            bq.put("4");
            bq.put("5");
            bq.put("6");
            bq.put("7");
            bq.put("8");
            bq.put("9");
        }).start();

        new Thread(()->{
            bq.get();
            bq.get();
            bq.get();
            bq.get();
            bq.get();
            bq.get();
            bq.get();
            bq.get();
            bq.get();
        }).start();
    }
}
