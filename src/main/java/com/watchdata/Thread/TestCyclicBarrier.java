package com.watchdata.Thread;

import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.*;

/**
 * @author zhibin.wang
 * @create 2019-08-13 10:47
 * @desc
 **/
public class TestCyclicBarrier {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(5);


    public void begin(){

        for (int i =0; i < 5; i++){
            new Thread(new CyclicBarrierTherad()).start();
        }
    }
    class CyclicBarrierTherad implements  Runnable{
        @Override
        public void run() {
            try {
                sleep(2000);
                cyclicBarrier.await();
            }catch (Exception e){

            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
    new TestCyclicBarrier().begin();
    }
}
