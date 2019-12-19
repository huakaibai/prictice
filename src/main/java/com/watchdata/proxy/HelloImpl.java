package com.watchdata.proxy;

/**
 * @author zhibin.wang
 * @desc
 **/
public class HelloImpl implements  HelloInterface {

    @Override
    public String sayHello(String msg) {
        System.out.println("他说："+msg);
        return msg;
    }
}
