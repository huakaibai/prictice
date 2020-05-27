package com.watchdata.Thread;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author 花开
 * @create 2020-05-24 23:32
 * @desc 测试生产者和消费者
 **/
public class TestProducer {

     static  Queue<Res>  queue = new LinkedList<>();

    private static Object producer = new Object();

    private static Object consumer = new Object();

    @AllArgsConstructor
    @ToString
    static class Res{
        public String name;
        public String sex;


    }

    static   class ProducerThread implements Runnable{

        @Override
        public void run() {
            Random random = new Random();
            while (true){
                try {

                    synchronized (queue){
                        /*if (queue.size() > 1){
                            queue.wait();
                        }*/
                        System.out.println(queue.size() + "生产这");
                        queue.wait();
                        Res hukai = new Res("hukai", "1" + random.nextInt());
                        queue.offer(hukai);
                        System.out.println(hukai + "生产者");
                       queue.notifyAll();
                    }
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    static   class  ConsumerThread implements  Runnable{

        @Override
        public void run() {
            while (true){
                try {

                    synchronized (queue){
                        System.out.println(queue.size()+"消费者");
                           queue.wait();


                        Res poll = queue.poll();
                        System.out.println(poll + "消费者");
                       queue.notifyAll();

                    }
                    Thread.sleep(1000);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ProducerThread()).start();
        new Thread(new ConsumerThread()).start();
    }

}
