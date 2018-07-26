package com.zookeeper;

import org.apache.curator.utils.ZookeeperFactory;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class DistributedLock implements Lock, Watcher {

    private ZooKeeper zk = null;
    private String ROOT_LOCK = "/locks";
    private String WAIT_LOCK;
    private String CURRENT_LOCK;

    private CountDownLatch countDownLatch;

    public DistributedLock(){
        try {
            zk = new ZooKeeper("", 4000, this);

            zk.create(ROOT_LOCK, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void lock() {
        if (this.tryLock()){
            System.out.println(Thread.currentThread().getName() + "->" +CURRENT_LOCK + "->获取锁成功");
        }

        waitForLock(WAIT_LOCK);
    }

    private void waitForLock(String prev) {
        try {
            Stat stat = zk.exists(prev, true);  //监听当前节点的上一个节点
            if (stat != null){
                System.out.println(Thread.currentThread().getName() + "->等待锁" + prev + "释放");
                countDownLatch.countDown();
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        try {
            zk.create(ROOT_LOCK+"/", "0".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            List<String> childrens = zk.getChildren(ROOT_LOCK, false);
            SortedSet<String> sortedSet = new TreeSet<>();
            for (String children:childrens){
                sortedSet.add(ROOT_LOCK+"/"+children);
            }

            String firstNode = sortedSet.first();
            SortedSet<String> lessThenMe = (TreeSet<String>)sortedSet.headSet(CURRENT_LOCK);

            if (CURRENT_LOCK.equals(firstNode)){
                return true;
            }
            if (!lessThenMe.isEmpty()){
                WAIT_LOCK = lessThenMe.last();
            }
            return false;
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        //zk.delete();
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent event) {
        if (this.countDownLatch != null){
            this.countDownLatch.countDown();;
        }
    }
}
