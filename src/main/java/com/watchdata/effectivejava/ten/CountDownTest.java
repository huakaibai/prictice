package com.watchdata.effectivejava.ten;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @author zhibin.wang
 * @create 2019-07-18 11:13
 * @desc
 **/
public class CountDownTest {


    public static long time (Executor executor,int concurrency,final Runnable action) throws Exception{

        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);


        for (int i = 0; i < concurrency;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    ready.countDown();
                    try {
                        start.await();
                        action.run();
                    }catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    }finally {
                        done.countDown();
                    }
                }
            });
        }

        ready.await();
        long startNaos = System.nanoTime();
        start.countDown();
        done.await();
        return System.nanoTime() - startNaos;
    }
}
