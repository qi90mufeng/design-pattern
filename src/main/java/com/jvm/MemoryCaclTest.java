package com.jvm;

import sun.tools.java.RuntimeConstants;

public class MemoryCaclTest {

    private static int flag = 1;
    private static String str = "str";
    private String ss = "ss";
    public static void main(String[] args) {
        System.out.println("maxMemory：" + Runtime.getRuntime().maxMemory());
        System.out.println("totalMemory：" + Runtime.getRuntime().totalMemory());
        //RuntimeConstants.
    }
}
