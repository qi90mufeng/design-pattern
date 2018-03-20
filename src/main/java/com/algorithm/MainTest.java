package com.algorithm;


import java.math.BigDecimal;

public class MainTest {
    public static void main(String[] args) {
        System.out.println(divide(new BigDecimal("0.3"), new BigDecimal("1")));
    }

    private static BigDecimal divide(BigDecimal first, BigDecimal second){
//        if (first == null || second == null || BigDecimal.ZERO.compareTo(first) == 0 || BigDecimal.ZERO.compareTo(second) == 0){
//            return "0%";
//        }
        return first.divide(second, 3, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(1, BigDecimal.ROUND_HALF_UP) ;
    }
}
