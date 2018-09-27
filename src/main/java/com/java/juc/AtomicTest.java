package com.java.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fujin
 * @version $Id: AtomicTest.java, v 0.1 2018-07-26 13:42 Exp $$
 */
public class AtomicTest implements Runnable{

    private AtomicInteger ai = new AtomicInteger(0);
    private static CountDownLatch latch = new CountDownLatch(50);

    public static void main(String[] args) {

        AtomicTest test = new AtomicTest();

        while (latch.getCount() > 0) {
            try {
                Thread thread = new Thread(test);
                thread.start();
            } catch (Exception e) {
                //
            }
            latch.countDown();
        }
    }

    @Override
    public void run() {
        try {
            // 阻塞
            // count = 0 就会释放所有的共享锁
            // 万箭齐发
            latch.await();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.printf("[当前线程: %s],数值: %s\n",Thread.currentThread().getName(),ai.incrementAndGet());
    }
}
