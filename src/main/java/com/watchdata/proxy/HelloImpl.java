package com.watchdata.proxy;

/**
 * @author zhibin.wang
 * @create 2019-09-11 14:05
 * @desc
 **/
public class HelloImpl implements  HelloInterface {

    @Override
    public String sayHello(String msg) {
        System.out.println("他说："+msg);
        return msg;
    }
}
