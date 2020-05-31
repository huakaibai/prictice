package com.watchdata.offer;

import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 现有的程序代码模拟产生了16个日志对象，并且需要运行16秒才能打印完这些日志，
 * 请在程序中增加4个线程去调用parseLog()方法来分头打印这16个日志对象，
 * 程序只需要运行4秒即可打印完这些日志对象。
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("begin:" + (System.currentTimeMillis() / 1000));
        /*
         * 模拟处理16行日志，下面的代码产生了16个日志对象，当前代码需要运行16秒才能打印完这些日志。
         * 修改程序代码，开四个线程让这16个对象在4秒钟打完。
         */
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(16);
        for (int i = 0; i < 16; i++) { // 这行代码不能改动
            final String log = "" + (i + 1);// 这行代码不能改动
            {
                try {
                    queue.put(log);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println(LocalTime.now());
            }
        });
        for (int i = 0; i < 4;i++){
            new Thread(new LogThread(cyclicBarrier,queue)).start();
        }


    }

    // parseLog方法内部的代码不能改动
    public static void parseLog(String log) {
        System.out.println(log + ":" + (System.currentTimeMillis() / 1000));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static class LogThread implements  Runnable{

        CyclicBarrier countDownLatch ;
        ArrayBlockingQueue<String> queue;
        public LogThread(CyclicBarrier countDownLatch,ArrayBlockingQueue<String> queue) {
            this.countDownLatch = countDownLatch;
            this.queue = queue;
        }

        @Override
        public void run() {



            for (int i = 0; i < 4; i++) { // 这行代码不能改动
                final String log = "" + (i + 1);// 这行代码不能改动
                {
                    try {
                        String  take = queue.take();
                        Test.parseLog(take);
                        countDownLatch.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }



        }
    }
}
