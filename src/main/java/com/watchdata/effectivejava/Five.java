package com.watchdata.effectivejava;

/**
 * @author zhibin.wang
 * @create 2019-07-10 16:57
 * @desc
 **/
public class Five {

    public synchronized void  add(){
        int i = 0;
        i++;
    }

    public static synchronized void end(){
        int k = 0;
        k--;
    }

    public static void main(String[] args) {
        synchronized (Five.class){
            System.out.println("aa");
        }
        end();
        Five five = new Five();
        five.add();
        end();
    }
}
