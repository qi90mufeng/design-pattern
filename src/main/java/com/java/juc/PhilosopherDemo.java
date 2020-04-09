package com.java.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PhilosopherDemo {

    public static void main(String[] args) {
        Semaphore sm = new Semaphore(5); //五只筷子
        Philosopher p1 = new Philosopher("哲学家1",sm);
        Philosopher p2 = new Philosopher("哲学家2",sm);
        Philosopher p3 = new Philosopher("哲学家3",sm);
        Philosopher p4 = new Philosopher("哲学家4",sm);
        Philosopher p5 = new Philosopher("哲学家5",sm);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        try {
            TimeUnit.SECONDS.sleep(120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
