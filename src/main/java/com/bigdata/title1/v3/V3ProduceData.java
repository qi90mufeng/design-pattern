package com.bigdata.title1.v3;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class V3ProduceData {
    private static List<Runnable> queue = new ArrayList<>();
    private static final int count = 1000000000; //url随机数
    private static final int total = 10000000; //url条数
    private static final int batch = 100000; //批量10w  total为batch倍数
    private static final String[] strs = new String[]{"www.baidu.com1", "www.google.com","www.biying.com","www.spring.io1"};
    private static double fpp = 0.01;//期望的误判率
    private static BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), total, fpp);
    private static CountDownLatch latch = new CountDownLatch(total / batch);
    private static Semaphore semaphore = new Semaphore(8);
    private static AtomicInteger initCount = new AtomicInteger();
    private static AtomicInteger initCount2 = new AtomicInteger();
    public static void main(String[] args) {
        initQueue();
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
        System.out.println("花费时间为: " + (end - start));
        System.out.println("生产了多少条数据: " + initCount);

//        long start2 = System.currentTimeMillis();
//        consumer();
//        long end2 = System.currentTimeMillis();
//        System.out.println("花费时间为: " + (end2 - start2));
//        System.out.println("消费了多少条数据: " + initCount2);
        for (int i = 0; i < count; i++){
            Random random = new Random();
            int index = random.nextInt(4);
            Random random2 = new Random();
            StringBuffer sb = new StringBuffer();
            String str = sb.append(strs[index]).append("/").append(random2.nextInt(count)).append(".html").toString();
            if (bloomFilter.mightContain(str)){
                //System.out.println(str + "在布隆过滤器中存在");
            }
            initCount2.incrementAndGet();
        }
    }
    private static void initQueue() {
        for (int i = 0; i < (total / batch); i++){
            queue.add(()-> produce());
        }
    }
    private static void produce() {
        for (int i = 0; i < batch; i++){
            Random random = new Random();
            int index = random.nextInt(4);
            Random random2 = new Random();
            StringBuffer sb = new StringBuffer();
            String str = sb.append(strs[index]).append("/").append(random2.nextInt(count)).append(".html").toString();
            bloomFilter.put(str);
            initCount.incrementAndGet();
        }
        semaphore.release();
        latch.countDown();
    }

    private static void consumer(){
        //写入文件
        File fileC = new File("D:/temp3/c/1.txt");
        try(
            BufferedWriter brC = new BufferedWriter(new FileWriter(fileC))) {
            for (int i = 0; i < count; i++){
                Random random = new Random();
                int index = random.nextInt(4);
                Random random2 = new Random();
                StringBuffer sb = new StringBuffer();
                String str = sb.append(strs[index]).append("/").append(random2.nextInt(count)).append(".html").toString();
                if (bloomFilter.mightContain(str)){
                    brC.write(str);
                    brC.newLine();
                }
                initCount2.incrementAndGet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
