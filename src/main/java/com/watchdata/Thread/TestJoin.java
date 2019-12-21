package com.watchdata.Thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zhibin.wang
 * @create 2019-08-13 11:37
 * @desc
 **/
public class TestJoin implements  Runnable {



    private String name;

    public TestJoin(String name) {
        this.name = name;
    }

    public void run() {
        System.out.printf("%s begins: %s\n", name, new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s has finished: %s\n", name, new Date());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new TestJoin(" one"));
        thread1.start();
       thread1.join();
        Thread thread2 = new Thread(new TestJoin(" two"));
        thread2.start();

          //  thread2.join();

        Thread thread3 = new Thread(new TestJoin(" three"));
        thread3.start();
        thread3.join();
    }

}
