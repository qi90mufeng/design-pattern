package com.algorithm.bloom;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.util.*;

/**
 * 布隆过滤器：一种空间效率极高的概率型算法和数据结构，用来判断一个元素是否在集合中
 * 核心：一个很长的二进制向量和一系列hash函数
 *
 * hash函数： MD5、SHA、
 * 优点：插入/查询 时间都是常数O(K)、空间高效率、全量存储但是不存储元素本身
 * 缺点：存在误算率、一般情况不能从布隆过滤器删除元素、数组长度以及hash函数个数确定过程复杂
 *
 * 应用场景：
 * 1、google著名的分布式数据库Bigtable以及HBase使用布隆过滤器查找不存在的行或列，以减少磁盘查找的IO次数
 * 2、文档存储检索系统也采用布隆过滤器检测先前存储的数据
 * 3、Google Chrome使用布隆过滤器加速安全浏览服务
 * 4、垃圾邮件地址过滤
 * 5、爬虫URL地址去重
 * 6、可以解决缓存穿透问题（缓存穿透式黑客攻击的常用手段）
 *
 * 用google guava轻松实现bloom filter（18以上才提供布隆过滤器）
 *
 * DEMO实例
 *
 *
 */
public class BloomFilterTest {

    private static final int insertions = 1000000;

    private static final double fpp = 0.001; //误判率

    public static void main(String[] args) {
        //初始化一个存储String数据的布隆过滤器，初始化大小为100w
        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), insertions, fpp);

        Set<String> sets = new HashSet<>();

        List<String> lists = new ArrayList<>(insertions);

        for (int i = 0; i < insertions; i++){
            String uuid = UUID.randomUUID().toString();
            bf.put(uuid);
            sets.add(uuid);
            lists.add(uuid);
        }

        int wrong = 0;  //布隆过滤器错误判断的次数
        int right = 0;  //布隆过滤器正确判断的次数

        for (int i = 0; i < 10000; i++){
            String test = i % 100 == 0 ? lists.get(i):UUID.randomUUID().toString();
            if (bf.mightContain(test)){
                if (sets.contains(test)){
                    right++;
                }else{
                    wrong++;
                }
            }
        }

        System.out.println("==============================wrong:" + wrong);
        System.out.println("==============================right:" + right);
    }
}
