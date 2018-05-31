package com.design.pattern.singleton.register;

import com.design.pattern.singleton.lazy.SingleTwo;
import com.design.pattern.singleton.register.BeanFactory;

import java.util.concurrent.CountDownLatch;

/**
 * @author fujin
 * @version $Id: RegisterThreadTest.java, v 0.1 2018-04-11 16:13 Exp $$
 */
public class RegisterThreadTest {

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

                    Object two = BeanFactory.getBean("com.design.pattern.singleton.register.Person");
                    System.out.println(two);
                }
            }.start();

            countDownLatch.countDown();
        }
    }
}
