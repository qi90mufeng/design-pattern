package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ////////////////////////////////////////////////////////////////////
 * //                          _ooOoo_                               //
 * //                         o8888888o                              //
 * //                         88" . "88                              //
 * //                         (| ^_^ |)                              //
 * //                         O\  =  /O                              //
 * //                      ____/`---'\____                           //
 * //                    .'  \\|     |//  `.                         //
 * //                   /  \\|||  :  |||//  \                        //
 * //                  /  _||||| -:- |||||-  \                       //
 * //                  |   | \\\  -  /// |   |                       //
 * //                  | \_|  ''\---/''  |   |                       //
 * //                  \  .-\__  `-`  ___/-. /                       //
 * //                ___`. .'  /--.--\  `. . ___                     //
 * //              ."" '<  `.___\_<|>_/___.'  >'"".                  //
 * //            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
 * //            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
 * //      ========`-.____`-.___\_____/___.-`____.-'========         //
 * //                           `=---='                              //
 * //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
 * //         佛祖保佑       永无BUG     永不修改                      //
 * ////////////////////////////////////////////////////////////////////
 *
 * @author fujin
 * @version $Id: StringTest.java, v 0.1 2018-09-14 Exp $$
 */
public class StringTest {


    public static void main(String[] args){
        //staticsStringCount();

        //staticsCount1();

        //convertOrder();

        rate(1);
    }

    //top4、掷n次，两个骰子的面之和是S。给定n，求出S的所有可能值和它的概率。
    //投掷多次，
    public static void rate(int n){
        Random r = new Random();
        int randomA = 1 + r.nextInt(5);
        int randomB = 1 + r.nextInt(5);

        Map<Integer, Integer> map = new HashMap<>(32);

        double total = Math.pow(6, n);//一共多少次
        int s = randomA + randomB;//等于s的有多少种？


        System.out.println(randomA);
    }

    //top3、输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变
    //句中单词以空格符隔开简单起见，标点符号和普通字母一样处理
    public static void convertOrder(){
        String english = "I am a Architect. I am from CHINA";

        String[] ss = english.split("\\s+");

        String[] newss = new String[ss.length];
        int y = ss.length - 1;
        for (int i = 0; i< ss.length; i++){
            newss[y] = ss[i];
            y--;
        }
        for (String s: newss){
            System.out.print(s + " ");
        }
    }

    //top2、上排在下排出现的次数
    public static void staticsCount1(){
        //上排
        int[] upints = new int[]{0,1,2,3,4,5,6,7,8,9};

        int[] downints = new int[]{6,2,1,0,0,0,1,0,0,0};

        Map<Integer, Integer> map = new HashMap<>(32);

        for (int up : upints){
            map.put(up,0);
        }

        for (int down : downints){
            Integer count = 0;
            if (map.containsKey(down)){
                count = map.get(down);
            }
            count++;
            map.put(down,count);
        }

        for (Map.Entry<Integer, Integer> a : map.entrySet()){
            System.out.println(a.getKey() + "出现-->" + a.getValue()+ "次");
        }
    }


    //top1、一堆字符串，统计每个字符串出现的次数
    public static void staticsStringCount(){
        String test = "一堆字符串，统计每个字符串出现的次数";

        Map<Character, Integer> map = new HashMap<>(32);

        for (char s: test.toCharArray()){
            Integer count = 0;
            if (map.containsKey(s)){
                count = map.get(s);
            }
            count++;
            map.put(s,count);
        }

        for (Map.Entry a : map.entrySet()){
            System.out.println(a.getKey() + "出现-->" + a.getValue()+ "次");
        }
    }
}
