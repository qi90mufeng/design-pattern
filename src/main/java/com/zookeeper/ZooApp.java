package com.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZooApp implements Watcher{
    private final static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper = null;
    /*
        watcher机制
        1、可以监听节点数据变更、删除、新增事件
        2、特性：watcher是一次性的

        如何注册监听
        1、getData
        2、exists
        3、getChildren

        触发监听事件：create/delete/setData
     */
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
            zooKeeper = new ZooKeeper("192.168.11.153:2181,192.168.11.154:2181,192.168.11.155:2181",
                    4000,new ZooApp());
            countDownLatch.await();

            //创建持久化节点
            zooKeeper.create("/zk-persis", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            //针对/zk-persis节点注册监听
            Stat stat = zooKeeper.exists("/zk-persis", true);

            //意味着接下来的第一个事务操作，都会触发相关事件
            stat = zooKeeper.setData("/zk-persis", "2".getBytes(), stat.getVersion());
            //再次修改
            stat = zooKeeper.setData("/zk-persis", "3".getBytes(), stat.getVersion());

            System.in.read(); //进程阻塞

            zooKeeper.close();

    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected){
            countDownLatch.countDown();
        }

        //输出事件类型
        System.out.println(event.getType());
    }
}
