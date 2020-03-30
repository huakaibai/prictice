package com.watchdata.zookeeper;

import lombok.Cleanup;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhibin.wang
 * @desc 基于zookeeper 实现分布式锁
 **/
public class DisTrutedLock {


    public static void main(String[] args) throws InterruptedException {
        // 重试策略，初始化每次重试之间需要等待的时间，基准等待时间为1秒。
      final  RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        // 使用默认的会话时间（60秒）和连接超时时间（15秒）来创建 Zookeeper 客户端
        String connectString = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
        @Cleanup final CuratorFramework client = CuratorFrameworkFactory.builder().
                connectString(connectString).
                connectionTimeoutMs(15 * 1000).
                sessionTimeoutMs(60 * 100).
                retryPolicy(retryPolicy).
                build();

        client.start(); // 连接zookeeper


        final String lockNode = "/lock_node";

    final    AtomicInteger atomicInteger = new AtomicInteger();
    final CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10;i++){
            new Thread(() -> {
               final  InterProcessMutex lock = new InterProcessMutex(client, lockNode);

                for(int j = 0 ;  j< 10; j++){
                    try {
                        lock.acquire();
                        System.out.println(Thread.currentThread().getName()+":获取锁成功!");
                        int i1 = atomicInteger.incrementAndGet();
                        System.out.println(Thread.currentThread().getName()+":自增值 i="+i1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        if (lock.isAcquiredInThisProcess()) {
                            try {
                                lock.release();
                                System.out.println(Thread.currentThread().getName()+":释放锁成功!");

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println("所有线程执行完成！");

    }
}
