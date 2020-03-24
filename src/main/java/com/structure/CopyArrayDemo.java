package com.structure;

import java.lang.reflect.Type;
import java.util.Arrays;

public class CopyArrayDemo {

    /**
     * 效率问题
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = new String[100];

        String[] newstrs1 = new String[100];
        System.arraycopy(strs, 0, newstrs1, 0, 100);  //底层：native方法   浅拷贝

        String[] newstrs2 = strs.clone();  //底层：native方法   浅拷贝

        String[] newstrs3 = Arrays.copyOf(strs, 100);   //底层：System.arraycopy   浅拷贝

        //for循环
    }

}
