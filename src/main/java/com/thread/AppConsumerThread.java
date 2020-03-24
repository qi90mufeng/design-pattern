package com.thread;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppConsumerThread extends Thread{

    private ThreadPoolExecutor pool;

    public AppConsumerThread(ThreadPoolExecutor pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try{
//            for(;;){
//                Integer take = queue.take();
//                System.out.println("queue开始消费 -> " + take + " 当前还有多少元素 -> " + queue.size());
//                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(100));
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
