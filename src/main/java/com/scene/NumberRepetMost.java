package com.scene;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class NumberRepetMost {
    public static void main(String[] args) {
        final int NUM = 100000;//十万个
        int t = 0;
        Random random = new Random();
        HashMap<Integer, Integer> hashMap = new HashMap<>(NUM);//key:数据 value:出现次数
        //模拟十万个数据
        while (t < NUM) {
            Integer i = random.nextInt(100000);
            if (hashMap.containsKey(i)) {  //如果存在,出现次数+1,不存在出现次数为1
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
            t++;
        }

        //用来存储最终的十个结果,优先级队列  小根堆形式,最小的在堆顶.
        //o1-o2 可以这样理解,如果返回正数,说明o1-o2>0.返回负数说明o1-o2<0
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>(10, Comparator.comparingInt(Map.Entry::getValue));


        //通过hashmap的entrySet进行遍历.
        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        //先随便放10个,priorityQueue会自动排序
        for (int i = 0; i < 10; i++) {
            priorityQueue.add(iterator.next());
        }

        //再放其他的
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> curEntry = iterator.next(); //当前遍历的.
            Map.Entry<Integer, Integer> topEntry = priorityQueue.peek(); //获得队列中最小的那一个.

            if (curEntry.getValue() > topEntry.getValue()) {
                priorityQueue.remove(topEntry);
                priorityQueue.add(curEntry);
            }
        }

        //打印结果
        Iterator<Map.Entry<Integer, Integer>> iterator2 = priorityQueue.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator2.next();
            System.out.println(entry.getKey() + ":出现了" + entry.getValue() + "次");
        }
    }
}
