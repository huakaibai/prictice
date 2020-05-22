package com.watchdata.Thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference 解决Aba得问题，通过添加一个版本号机制。
 */
public class ABA {
        private static AtomicInteger atomicInt = new AtomicInteger(100);
        private static AtomicStampedReference atomicStampedRef = new AtomicStampedReference(100, 0);

        public static void main(String[] args) throws InterruptedException {

                Thread thread1 = new Thread(() ->{
                        atomicInt.compareAndSet(100,101);
                        atomicInt.compareAndSet(101,100);
                });

                Thread thread2 = new Thread(() -> {
                        boolean b = atomicInt.compareAndSet(100, 101);
                        System.out.println(b);
                });

                thread1.start();

                thread2.start();

                thread1.join();

                thread2.join();


                Thread thread3 = new Thread(() ->{
                        int stamp = atomicStampedRef.getStamp();
                        System.out.println(stamp + "    3");

                        try {
                                Thread.sleep(100);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        atomicStampedRef.compareAndSet(100,101,stamp,atomicStampedRef.getStamp()+1);
                        atomicStampedRef.compareAndSet(101,100,atomicStampedRef.getStamp(),atomicStampedRef.getStamp()+1);

                });

                Thread thread4 = new Thread(() ->{
                        int stamp = atomicStampedRef.getStamp();
                        System.out.println(stamp + "     4");
                        try {
                                Thread.sleep(50);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        boolean b = atomicStampedRef.compareAndSet(101, 101, stamp, atomicStampedRef.getStamp() + 1);
                        System.out.println(b);
                });

                thread3.start();

                thread4.start();

                thread3.join();

                thread4.join();




        }
}