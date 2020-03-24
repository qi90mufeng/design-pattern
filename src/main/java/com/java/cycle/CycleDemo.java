package com.java.cycle;

/**
 * 标签跳出多重循环
 */
public class CycleDemo {

    public static void main(String[] args) {
        A:
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                System.out.println("i->" + i + " j->" + j);
                if (i == 2 && j ==2)
                    break A;
            }
        }

    }
}
