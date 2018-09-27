package com.java;

/**
 * @author fujin
 * @version $Id: DoubleDemo.java, v 0.1 2018-07-26 15:06 Exp $$
 */
public class DoubleDemo {

    public static void main(String[] args) {

        //returns the bits that represent the floating-point number
        System.out.println("Value = " + Double.doubleToRawLongBits(2.5d));
    }
}