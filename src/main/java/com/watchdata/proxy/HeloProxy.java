package com.watchdata.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhibin.wang
 * @desc
 **/
public class HeloProxy implements InvocationHandler {

    private static final Class<?>[] IFACES = new Class<?>[] { HelloInterface.class };
    private final HelloInterface helloInterface;
    private final HelloInterface realInterface;

    public HeloProxy(HelloInterface helloInterface) {
        realInterface = helloInterface;
        this.helloInterface = (HelloInterface) Proxy.newProxyInstance(HelloInterface.class.getClassLoader(),IFACES,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String name = method.getName();
        System.out.println("当前调用方法"+name);
        return  method.invoke(realInterface,args);

    }


    public HelloInterface getHelloInterface() {
        return helloInterface;
    }

    public static void main(String[] args) {
        HelloInterface helloInterface = new HelloImpl();
        HeloProxy heloProxy = new HeloProxy(helloInterface);
        String string = heloProxy.getHelloInterface().sayHello("动态代理");
        System.out.println(string);
    }
}
