package com.bigdata.title1.v1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerData {
    private static final int total = 1000; //文件数
    private static List<Runnable> queue = new ArrayList<>();
    private static CountDownLatch latch = new CountDownLatch(total);
    private static Semaphore semaphore = new Semaphore(8);
    private static AtomicInteger initCount1 = new AtomicInteger();
    private static AtomicInteger initCount2 = new AtomicInteger();
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
        System.out.println("消费了多少条数据1: " + initCount1);
        System.out.println("消费了多少条数据2: " + initCount2);
//        2核cpu   2.70GHZ 内存4G
//        花费时间为: 5543
//        消费了多少条数据: 19998854
    }
    private static void initQueue(int total) {
        for (int i = 0; i < total; i++){
            final int fi = i;
            queue.add(()-> consumer(fi));
        }
    }

    private static void consumer(int i){
        Set<String> set = new HashSet<>();
        File file = new File("D:/temp/a/" + i + ".txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String str = null;
            while((str = br.readLine()) != null){
                set.add(str);
                initCount1.incrementAndGet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //写入文件
        File fileC = new File("D:/temp/c/" + i + ".txt");
        //
        File fileB = new File("D:/temp/b/" + i + ".txt");
        try(BufferedReader brB = new BufferedReader(new FileReader(fileB));
            BufferedWriter brC = new BufferedWriter(new FileWriter(fileC))) {
            String str = null;
            while((str = brB.readLine()) != null){
                initCount2.incrementAndGet();
                if (set.contains(str)){
                    brC.write(str);
                    brC.newLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        semaphore.release();
        latch.countDown();
    }

}
