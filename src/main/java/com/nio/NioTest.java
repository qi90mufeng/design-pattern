package com.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
 * @version $Id: NioTest.java, v 0.1 2018-08-29 Exp $$
 */
public class NioTest implements Runnable{

    private static volatile int bytesRead = -1;
    private static volatile int count = 0;
    private final static int num = 4;

    private ExecutorService service = Executors.newFixedThreadPool(num);//ThreadPoolExecutor

    private static void nio(String fileName) {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile(fileName, "rw");
            // channel获取数据
            FileChannel fileChannel = aFile.getChannel();
            // 初始化Buffer，设定Buffer每次可以存储数据量
            // 创建的Buffer是1024byte的，如果实际数据本身就小于1024，那么limit就是实际数据大小
            ByteBuffer buf1 = ByteBuffer.allocate(1024 * 1024 * 4);  // 4m
            ByteBuffer buf2 = ByteBuffer.allocate(1024 * 1024 * 4);
            // channel中的数据写入Buffer
            bytesRead = fileChannel.read(buf1);
            System.out.println("bytesRead:" + bytesRead);

            while (bytesRead != -1) {
                // Buffer切换为读取模式
                buf1.flip();
                // 读取数据
                while (buf1.hasRemaining()) {
                    buf1.get();
                    //System.out.print((char) buf.get());
                }
                // 清空Buffer区
                buf1.compact();
                // 继续将数据写入缓存区
                bytesRead = fileChannel.read(buf1);
                System.out.println("bytesRead:" + bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        NioTest.nio("E:/webcat/WeChat Files/fuh0-0/Files/test.txt");
    }

    @Override
    public void run(){

    }
}


