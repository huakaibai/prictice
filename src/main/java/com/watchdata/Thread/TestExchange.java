package com.watchdata.Thread;

import java.util.concurrent.Exchanger;

/**
 * @author zhibin.wang
 * @desc
 * 两个线程之间传输数据，Exchanger中的public V exchange(V x)方法被调用后等待另一个线程到达交换点（如果当前线程没有被中断），然后将已知的对象传给它，返回接收的对象。
 *
 * 如果另外一个线程已经在交换点等待，那么恢复线程计划并接收通过当前线程传给的对象：
 **/
public class TestExchange {



    public static void main(String[] args) {
        TestExchange  t = new TestExchange();
        Tool tool1 = new Tool("AAG");
        Tool tool2 = new Tool("BBG");
        Exchanger<Tool> exchanger = new Exchanger();
        staff aStaff = new  staff("A",tool1,1000,exchanger);
        new Thread(aStaff).start();


        staff aStaff2= new  staff("B",tool2,500,exchanger);
        new Thread(aStaff2).start();
    }






}


class  Tool{

    String name;

    public Tool(String name) {
        this.name = name;
    }
}
class staff implements Runnable{

    String name;
    Tool tool;
    long time;

    Exchanger<Tool> exchanger ;

    public staff(String name, Tool tool, long time, Exchanger<Tool> exchanger) {
        this.name = name;
        this.tool = tool;
        this.time = time;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        System.out.println("我是员工:"+name+" 我正在使用工具："+tool.name);
        // 等待交换数据

        try {    Thread.sleep(time);
            tool = exchanger.exchange(tool);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是员工:"+name+" 我正在使用交换工具："+tool.name);


    }
}