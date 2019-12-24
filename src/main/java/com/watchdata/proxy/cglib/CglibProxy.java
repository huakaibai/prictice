package com.watchdata.proxy.cglib;

import com.watchdata.proxy.HelloImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhibin.wang
 * @desc cglib 代理
 **/
public class CglibProxy implements MethodInterceptor {
    private Object targetObject;

    public Object getInstance(Object target) {
        // 设置需要创建子类的类
        this.targetObject = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事物");
        Object result = methodProxy.invoke(targetObject, args);
        System.out.println("关闭事物");
        // 返回代理对象
        return result;

    }

    public static void main(String[] args) {

        CglibProxy cglibProxy = new CglibProxy();
        HelloImpl helloImpl = (HelloImpl) cglibProxy.getInstance(new HelloImpl());
        helloImpl.sayHello("aa");

    }
}
