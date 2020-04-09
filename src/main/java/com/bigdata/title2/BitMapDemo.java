package com.bigdata.title2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class BitMapDemo {
    //问题描述: 在2.5亿个整数中找出不重复的整数
    //注意: 内存不足以容纳2.5亿个整数
    private static final int total = 250000000; //2.5亿个整数
    private static AtomicInteger initCount = new AtomicInteger();
//    private static List<Integer> list = new ArrayList<>(); //小数据量测试程序是否正确
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        byte[] flag = new byte[total * 2];
        Random random = new Random();
        for(int i = 0; i < total; i++){
            int result = random.nextInt(total);
//            list.add(result);
            if (flag[2 * result] == 1){
                //表示多个
                continue;
            }
            if(flag[2 * result + 1] == 0){
                flag[2 * result + 1] = 1;
            }else if(flag[2 * result + 1] == 1){
                flag[2 * result] = 1;
                flag[2 * result + 1] = 0;
            }
        }
        for(int i = 0; i < total; i++){
            if (flag[2 * i] != 1 && flag[2 * i + 1] == 1){
                initCount.incrementAndGet();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间为: " + (end - start));
        System.out.println("无重复多少条数据: " + initCount);
        //cpu=2核  内存=4G 2.70GHZ  -Xms2048m -Xmx2048m
        //花费时间为: 24375
        //无重复多少条数据: 91962576

        //cpu=2核  内存=4G 2.70GHZ  -Xms2048m -Xmx2048m
        //花费时间为: 28277
        //无重复多少条数据: 91966771

        //cpu=2核  内存=4G 2.70GHZ  -Xms2048m -Xmx2048m
        //花费时间为: 26470
        //无重复多少条数据: 91963397

        //cpu=2核  内存=4G 2.70GHZ  -Xms1024m -Xmx1024m
        //花费时间为: 28301
        //无重复多少条数据: 91977129

        //cpu=2核  内存=4G 2.70GHZ  -Xms768m -Xmx768m
        //花费时间为: 27763
        //无重复多少条数据: 91965103
    }
}
