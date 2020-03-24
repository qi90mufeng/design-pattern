package com.structure;

public class StringDemo {

    public static void main(String[] args){

    }

    private void newNumObject(){
        //建立了一个对象，编译器做了优化
        //   "C:\Program Files\Java\jdk1.8.0_191\bin\javap" -c StringDemo.class
        /**
         * Compiled from "StringDemo.java"
         * public class com.structure.StringDemo {
         *   public com.structure.StringDemo();
         *     Code:
         *        0: aload_0
         *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         *        4: return
         *
         *   public static void main(java.lang.String[]);
         *     Code:
         *        0: ldc           #2                  // String welcometo360
         *        2: astore_1
         *        3: return
         * }
         */
        String s = "welcome" + "to" + 360;
    }
//    private static void a(){
//        int a =100,b=50,c=a---b,d=a---b;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//    }
//    private void canNotCompile(){
////        String s;
////        System.out.println("s="+s);
//    }
}
