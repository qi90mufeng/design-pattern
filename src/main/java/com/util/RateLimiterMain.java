package com.util;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.CountDownLatch;

/**
 * 令牌桶算法的限流器
 */
public class RateLimiterMain {

    public static void main(String[] args) {
        //RateLimiter rateLimiter = RateLimiter.create(10)
        //create 每秒生成10个令牌的限流器，即100ms生成一个，并最多保存10个令牌
        RateLimiter rateLimiter = RateLimiter.create(10);

        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                latch.countDown();
                rateLimiter.acquire();  //acquire 消费一个令牌
                System.out.println("pass");
            }).start();
        }

        try{
            latch.await();
        }catch (Exception e){

        }
    }
}
