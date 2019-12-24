package com.watchdata.jvm.TestThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhibin.wang
 * @desc
 **/
public class TestThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        List<Test> list = new ArrayList<>();
        for (int i=0;i< 10000;i++){
            list.add(new Test());
        }
        List<Future<String>> futures = executorService.invokeAll(list);
    }

}

class Test implements Callable<String> {



    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return null;
    }
}