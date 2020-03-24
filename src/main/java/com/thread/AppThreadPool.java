package com.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.jboss.netty.handler.execution.ExecutionHandler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppThreadPool extends Thread{

//    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }


    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10000);

    @Override
    public void run(){
        try {
            System.out.println("执行任务 + " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
////        System.out.println(toBinary(ctl.get()));
//        System.out.println(toBinary(runStateOf(1)));
        test1();
    }


    //试验线程池  生产者-消费者模式
    //需求、场景

    //落地方案

    //应用

    //原理

    private static void test1(){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 8, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20), new ThreadFactoryBuilder().setNameFormat("app-thread-pool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());

        AppProducerThread producerThread = new AppProducerThread(pool);
        producerThread.start();
    }


    private static String toBinary(int a){
        String num = "";
        while(a < 0){
            num = a % 2 + num;
            a = a / 2;
        }
        return num;
    }
}
