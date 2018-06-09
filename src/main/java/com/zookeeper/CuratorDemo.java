package com.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import sun.reflect.generics.tree.Tree;

public class CuratorDemo {
    /*




    */
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("192.168.11.153:2181,192.168.11.154:2181,192.168.11.155:2181")
                .sessionTimeoutMs(4000).retryPolicy(new ExponentialBackoffRetry(1000,3))
                .namespace("curator")
                .build();

        //级联删除
//        curatorFramework.create().creatingParentsIfNeeded()
//                .withMode(CreateMode.PERSISTENT).forPath("/sec/node1","val".getBytes());
//
//        curatorFramework.delete().deletingChildrenIfNeeded().forPath("/sec/node1");


        addListenWithNodeCache(curatorFramework,"/mic");

        curatorFramework.setData().forPath("/mic");

        Thread.sleep(1000);

        curatorFramework.create().creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT).forPath("/mic/node1","val".getBytes());
        curatorFramework.close();

        //PathChildCache
        //NodeCache
        //TreeCache
    }

    private static void addListenWithTreeCache(CuratorFramework curatorFramework, String path) throws Exception {
        TreeCache treeCache = new TreeCache(curatorFramework, path);
        TreeCacheListener listener = new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                System.out.println("Receive Event：" + treeCacheEvent);
            }
        };
        treeCache.getListenable().addListener(listener);
        treeCache.start();
    }
    private static void addListenWithNodeCache(CuratorFramework curatorFramework, String path) throws Exception {
        final NodeCache nodeCache = new NodeCache(curatorFramework, path);

        NodeCacheListener nodeCacheListener = new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("Receive Event：" + nodeCache.getCurrentData().getPath());
            }
        };
        nodeCache.getListenable().addListener(nodeCacheListener);
        nodeCache.start();
    }
}
