/**
 * sinafenqi.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fujin
 * @version $Id: DownloadDemo.java, v 0.1 2018-07-27 20:46 Exp $$
 */
public class DownloadDemo {

    public static void main(String[] args) {
        startDownload();
    }

    private static void startDownload() {
        Book book = new Book();
        book.setBookname("飞剑问道");
        book.setUrl("https://www.xs222.tw/html/16/16593/");
        File file = new File("飞剑问道.txt");
        try(
        FileWriter out = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(out);) {
            //飞剑问道
            List<String> allLinks = getAllLinks("https://www.xs222.tw/html/16/16593/");
            List<Charpter> charpters = new ArrayList<>();
            for (String url :
                    allLinks) {
                Charpter charpter = getCharpter(url);
                bw.write(charpter.getName());
                bw.newLine();
                bw.newLine();
                bw.write(charpter.getContent());
                bw.newLine();
                bw.newLine();
                System.out.println("章节：" + charpter.getName() + " 已下载");
                charpters.add(charpter);
            }
            book.setClist(charpters);
        }catch(Exception e){
            //
        }
    }

    /**
     * 获取所有章节的链接
     * @param url
     * @return
     */
    private static List<String> getAllLinks(String url){
        List<String> list = new ArrayList<>();
        try {
            Document doc =  Jsoup.connect(url).get();
            Elements eles = doc.getElementById("list").getElementsByTag("a");
            for (Element ele: eles) {
                String link = ele.attr("abs:href");  //abs: 获取绝对路径
                list.add(link);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取每一个章节标题与内容
     * @param url
     * @return
     */
    private static Charpter getCharpter(String url){
        Charpter charpter = new Charpter();
        try {
            //二阶段
            //http协议   request  response
            //将获取到的http资源进行转化
            Document doc = Jsoup.connect(url).get();

            String content = doc.getElementById("content").text();

            String name = doc.getElementsByTag("h1").text();

            charpter.setContent(content);
            charpter.setName(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return charpter;
    }
}
