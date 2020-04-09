package com.bigdata.title1.v2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class V2ProduceData {
    private static List<Runnable> queue = new ArrayList<>();
    private static final String basePackage = "D:/temp5/";
    private static final int count = 1000000000; //url随机数
    private static final int total = 10000000; //url条数
    private static final int batch = 100000; //批量10w  total为batch倍数
    private static final String[] strs = new String[]{"www.baidu.com1", "www.google.com","www.biying.com","www.spring.io1"};
    private static CountDownLatch latch = new CountDownLatch(total / batch);
    private static Semaphore semaphore = new Semaphore(8);
    private static AtomicInteger initCount = new AtomicInteger();
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
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("花费时间为: " + (end - start));
        System.out.println("生产了多少条数据: " + initCount);
//        cpu=2核  内存=4G 2.70GHZ  批量=10000个数据   Semaphore=4
//        花费时间为: 469202
//        生产了多少条数据: 19970248

//        cpu=2核  内存=4G 2.70GHZ  批量=10000个数据   Semaphore=8
//        花费时间为: 319174
//        生产了多少条数据: 19964474

//        cpu=2核  内存=4G 2.70GHZ  批量=100000个数据   Semaphore=8
//        花费时间为: 141257
//        生产了多少条数据: 19391880

//        cpu=2核  内存=4G 2.70GHZ  批量=1000000个数据   Semaphore=8
//        花费时间为: 122486
//        生产了多少条数据: 15979162
    }

    private static void initQueue() {
        for (int i = 0; i < (total / batch); i++){
            queue.add(()-> produce(count, "a"));
            queue.add(()-> produce(count, "b"));
        }
    }
    private static void produce(int count, String ab) {
        Map<Integer ,List<String>> map = new HashMap<>();
        for (int i = 0; i < batch; i++){
            Random random = new Random();
            int index = random.nextInt(4);
            Random random2 = new Random();
            StringBuffer sb = new StringBuffer();
            String str = sb.append(strs[index]).append("/").append(random2.nextInt(count)).append(".html").toString();
            int hash = (str.hashCode() & Integer.MAX_VALUE) % 1000;
            List<String> list = new ArrayList<>();
            if (map.containsKey(hash)){
                list = map.get(hash);
            }
            list.add(str);
            map.put(hash, list);
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()){
            createFile(ab, entry);
        }
        semaphore.release();
        latch.countDown();
    }
    private static void createFile(String ab, Map.Entry<Integer, List<String>> map){
        String fileName = basePackage + ab + "/" + map.getKey() + ".txt";
        synchronized (map.getKey()){
            try (RandomAccessFile rf = new RandomAccessFile(fileName, "rw")){
                for (String str : map.getValue()){
                    initCount.incrementAndGet();
                    rf.seek(rf.length());  //将指针移动到文件末尾
                    rf.writeBytes(str + "\n"); //字符串末尾需要换行符
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
