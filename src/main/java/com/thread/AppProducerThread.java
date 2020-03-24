package com.thread;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppProducerThread  extends Thread{

    private ThreadPoolExecutor pool;

    public AppProducerThread(ThreadPoolExecutor pool) {
        this.pool = pool;
    }

    /**
     * 生产者：外界提交到线程池的方法
     * 消费者：线程池中的线程进行消费
     * 1、生产者生产平均速率 >   消费者消费速率： 会产生什么问题？
     *    队列会装满，线程池执行拒绝策略，此时需要合理安排策略
     * 2、生产者生产平均速率 =  消费者消费速率：一般不会去考虑
     * 3、生产者生产平均速率 < 消费者消费速率：队列可以设置小一点
     *
     */
    @Override
    public void run() {
        //生产者速率：90~100ms   消费者速率：360~400ms    coreSize: 4   maxSize: 8  队列基本为0-1

        int i = 1;
        for (;;){
            final int fi = i;
            FutureTask<Integer> task = new FutureTask<>(() -> {
                //业务逻辑
                int consumerTime = ThreadLocalRandom.current().nextInt(40) + 360;
                System.out.println(System.currentTimeMillis() + " pool消费消息 -> " + fi
                        + " 核心线程数 -> " + pool.getCorePoolSize()
                        + " 最大线程数 -> " + pool.getMaximumPoolSize()
                        + " 队列大小 -> " + pool.getQueue().size()
                        + " 消费时间 -> " + consumerTime);
                //TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(10) + 90);  //任务消费90~100ms以内
                blockThread(consumerTime);
                return fi;
            });
            i++;
            try{
                int produceTime = ThreadLocalRandom.current().nextInt(10) + 90;
                System.out.println(System.currentTimeMillis() + " 开始生成消息 -> " + fi
                        + " 核心线程数 -> " + pool.getCorePoolSize()
                        + " 最大线程数 -> " + pool.getMaximumPoolSize()
                        + " 队列大小 -> " + pool.getQueue().size()
                        + " 生产时间 -> " + produceTime);
                pool.submit(task);
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(10) + 90); //任务生产90~100ms以内
               // TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(10) + 990); //任务生产990~1000ms以内
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    private void blockThread(int consumerTime) {
        //突发时间阻塞线程5s, > 360的话，出现问题概率为 2/40 = 5%
        if (consumerTime < 362){
            try {
                System.out.println("消费者出现故障，导致5s内无法任务执行完成");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            try {
                TimeUnit.MILLISECONDS.sleep(consumerTime);  //任务消费360~400ms以内
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
