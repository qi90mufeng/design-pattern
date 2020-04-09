package com.bigdata.title1.v1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class V1ProduceData {
    private static List<Runnable> queue = new ArrayList<>();
    private static final int count = 1000000000; //url随机数
    private static final int total = 10000000; //url条数
    private static final String[] strs = new String[]{"www.baidu.com1", "www.google.com","www.biying.com","www.spring.io1"};
    private static CountDownLatch latch = new CountDownLatch(total);
    private static Semaphore semaphore = new Semaphore(8);
    private static AtomicInteger initCount = new AtomicInteger();
    public static void main(String[] args) {
        initQueue(total);
        long start = System.currentTimeMillis();
        queue.parallelStream().forEach(m -> {
            try {
                semaphore.acquire();
                new Thread(m).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("花费时间为: " + (end - start));
        System.out.println("生产了多少条数据: " + initCount);
//        2核cpu   2.70GHZ 内存4G
//        花费时间为: 14723507   ≈245min≈4h
//        生产了多少条数据: 20000000   对的 10000000 * 2 = 2000 0000
    }

    private static void initQueue(int total) {
        for (int i = 1; i <= total; i++){
            queue.add(()-> produce(count, "a"));
            queue.add(()-> produce(count, "b"));
        }
    }
    private static void produce(int count, String ab) {
        Random random = new Random();
        int i = random.nextInt(4);
        Random random2 = new Random();
        StringBuffer sb = new StringBuffer();
        String str = sb.append(strs[i]).append("/").append(random2.nextInt(count)).append(".html").toString();
        createFile(ab, str);
        //统计个数
        initCount.incrementAndGet();
        semaphore.release();
        latch.countDown();
    }
    private static void createFile(String ab, String str){
        int hash = (str.hashCode() & Integer.MAX_VALUE) % 1000;
        try {
            String fileName = "D:/temp/" + ab + "/" + hash + ".txt";
            RandomAccessFile rf = new RandomAccessFile(fileName, "rw");
            rf.seek(rf.length());  //将指针移动到文件末尾
            rf.writeBytes(str + "\n"); //字符串末尾需要换行符
            rf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
