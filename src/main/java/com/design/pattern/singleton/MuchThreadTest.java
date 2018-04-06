package com.design.pattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @author fujin
 * @version $Id: MuchThreadTest.java, v 0.1 2018-04-03 9:23 Exp $$
 */
public class MuchThreadTest {

    public static void main(String[] args) {
        int count = 2000;

        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    }catch(Exception e){

                    }

//                    SingleOne one = SingleOne.getInstance();
//                    System.out.println(one);

                    SingleTwo two = SingleTwo.getInstance();
                    System.out.println(two);
                }
            }.start();

            countDownLatch.countDown();
        }
    }
}
