package com.watchdata.effectivejava.ten;

import java.util.concurrent.TimeUnit;

/**
 * @author zhibin.wang
 * @create 2019-07-17 15:10
 * @desc
 **/
public class StopThread {

    public static volatile boolean stopFlag = false;

    public static void main(String[] args) throws InterruptedException {


        Thread TestTread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopFlag){
                    System.out.println(i++);
                }
            }
        });
        TestTread.start();
        TimeUnit.SECONDS.sleep(1);
        stopFlag = true;
    }


}
