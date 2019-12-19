package com.watchdata.Thread.condition;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhibin.wang
 * @create 2019-12-16 10:12
 * @desc 测试condition 类似Wait和notify
 **/
public class TestCondition {

     static class Res{
        public String name;
        public String sex;
        public boolean flag = false;
        public Lock lock = new ReentrantLock();

    }


    static class writeThread implements Runnable{
        private Res res;
        Condition condition ;

        public writeThread(Res res, Condition condition) {
            this.res = res;
            this.condition = condition;
        }

        @Override
        public void run() {
            int count = 0;
            while (true){
                try {
                    res.lock.lock();
                    if (!res.flag){

                        if (count % 2 == 0){
                            res.name = "花开";
                            res.sex = "男";
                        }else{
                            res.name = "花落";
                            res.sex = "女";
                        }
                        count++;
                        res.flag = true;
                        condition.signal();

                    }else {

                            condition.await();

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    res.lock.unlock();
                }

            }

        }
    }

    static class  readThread implements  Runnable{
        private Res res;
        Condition condition ;

        public readThread(Res res, Condition condition) {
            this.res = res;
            this.condition = condition;
        }

        @Override
        public void run() {
            while (true){
             try {
                 res.lock.lock();
                 if (res.flag){
                     System.out.println(res.name +":"+ res.sex);
                     res.flag = false;
                     condition.signal();
                 }else {
                     try {
                         condition.await();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }catch (Exception e){

             }finally {
                res.lock.unlock();
             }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

         Res res = new Res();
        Condition condition = res.lock.newCondition();
      new Thread(new writeThread(res,condition)).start();
        new Thread(new readThread(res,condition)).start();

/*        BlockingDeque<String> arrays = new ArrayBlockingQueue<>(3);
        arrays.add("李四");
        arrays.add("张军");
        arrays.add("张军");
        // 添加阻塞队列
        arrays.offer("张三", 1, TimeUnit.SECONDS);
        String poll = arrays.poll();*/

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()-> System.out.println("通过excute提交"));

    }

}
