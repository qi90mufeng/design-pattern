package com.structure;

import java.util.BitSet;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class BitMapDemo {
    //2.5亿个随机数(0 - 2.5亿)中找出不存在的整数,内存不足以容纳2.5亿个整数
    private static AtomicInteger initCount = new AtomicInteger();
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BitSet bitSet = new BitSet(250000000);
        Random random = new Random();
        for(int i=0; i < 250000000; i++){
            int result = random.nextInt(250000000);
            bitSet.set(result);
        }
        for(int i=0; i < 250000000; i++){
            if (!bitSet.get(i)){
                initCount.incrementAndGet();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间为: " + (end - start));
        System.out.println("生产了多少条数据: " + initCount);
    }
}
