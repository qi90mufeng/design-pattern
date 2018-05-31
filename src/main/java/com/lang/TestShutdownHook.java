package com.lang;

/**
 *
 * @author fujin
 * @version $Id: TestShutdownHook.java, v 0.1 2018-05-16 15:55 Exp $$
 * java8
 *
 * 使用场景：
 */
public class TestShutdownHook {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 定义线程1
        Thread thread1 = new Thread(() -> System.out.println("thread1..."));

        // 定义线程2
        Thread thread2 = new Thread(() -> System.out.println("thread2..."));

        // 定义关闭线程
        Thread shutdownThread = new Thread(() -> System.out.println("shutdownThread..."));

        // jvm关闭的时候先执行该线程钩子
        Runtime.getRuntime().addShutdownHook(shutdownThread);

        thread1.start();
        thread2.start();
    }
}
