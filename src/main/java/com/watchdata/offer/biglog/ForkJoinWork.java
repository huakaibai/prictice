package com.watchdata.offer.biglog;

import lombok.AllArgsConstructor;

import java.util.concurrent.RecursiveTask;

/**
 * @author 花开
 * @create 2020-05-22 23:33
 * @desc fork join
 **/
@AllArgsConstructor
public class ForkJoinWork extends RecursiveTask {

    private int start;

    private int end;

    private static  LogIpAnalysis logAnalysis = new LogIpAnalysis();

    public static final  int critical = 500;//临界值

    @Override
    protected Object compute() {
        int length = end - start;
        if (length <= critical){
            logAnalysis.createLog((int) end);
        }else{
            ForkJoinWork subTask1 = new ForkJoinWork(start, (start + end) / 2);
            subTask1.fork();
            ForkJoinWork subTask2 = new ForkJoinWork((start + end) / 2 + 1 , end);
            subTask2.fork();
            subTask1.join();
            subTask2.join();
        }


        return null;
    }
}
