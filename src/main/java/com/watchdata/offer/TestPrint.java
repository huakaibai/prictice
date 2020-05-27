package com.watchdata.offer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 花开
 * @create 2020-05-24 14:44
 * @desc 三个线程顺序打印各 XYZ,并且打印10编
 **/
public class TestPrint {


    private  Integer excuteNum = 1;

    public Lock lock = new ReentrantLock();
    public Condition[] conditions  = new Condition[3];

    private int count = 0;

    class PrintThread implements  Runnable{

      private int  num ;
      private String str;

      public PrintThread(int num,String str){
          this.num = num;
          this.str = str;

      }
        @Override
        public void run() {
            for (int i=0; i < 10;i++){
            while (true){
               synchronized (excuteNum){
                    if (excuteNum == num){
                        System.out.print(str);
                        excuteNum ++;
                        if (excuteNum > 3){
                            System.out.println("");
                            excuteNum = 1;
                        }

                        break;
                   }

                }
            }

            }
        }
    }

    class PrintThread2 implements  Runnable{
        private int num;

        private String str;


        private int next;

        public PrintThread2(int num,String str){

            this.num = num;
            this.str = str;
            if (num == 0 ){
                next = 1;
            }else if (num == 1){
                next = 2;
            }else
            {
                next = 0;
            }


        }

        @Override
        public void run() {


            for (int i = 0; i < 10;i++){

                try {
                    lock.lock();
                    while (count != num){
                        conditions[num].await();
                    }
                    count++;
                    if (count > 2){
                        count = 0 ;
                    }

                    System.out.print(str);
                    conditions[next].signal();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }

        }
    }

    public static void main(String[] args) {
        TestPrint testPrint = new TestPrint();
      /*  new Thread(testPrint.new PrintThread(1, "X")).start();
        new Thread(testPrint.new PrintThread(2, "Y")).start();
        new Thread(testPrint.new PrintThread(3, "Z")).start();*/

        for (int i =0;i<3;i++){
            testPrint.conditions[i] = testPrint.lock.newCondition();
        }
        new Thread(testPrint.new PrintThread2(0,"X")).start();
        new Thread(testPrint.new PrintThread2(1,"y")).start();
        new Thread(testPrint.new PrintThread2(2,"z")).start();
    }
}
