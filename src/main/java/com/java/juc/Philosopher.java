package com.java.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//哲学家
public class Philosopher extends Thread {

    private String name;
    private Semaphore sm;

    public Philosopher(String name, Semaphore sm) {
        this.name = name;
        this.sm = sm;
    }

    @Override
    public void run(){
        while(true){
            System.out.println(name + "正在思考 -> 准备拿起筷子吃饭");
            try {
                sm.acquire();
                System.out.println(name + "拿起一只筷子");
                sm.acquire();
                System.out.println(name + "拿起另一只筷子 -> 开始吃饭 1s");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sm.release();
            System.out.println(name + "放下一只筷子");
            sm.release();
            System.out.println(name + "放下另一只筷子 -> 开始思考 1s");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}