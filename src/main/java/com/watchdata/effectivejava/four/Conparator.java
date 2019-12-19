package com.watchdata.effectivejava.four;

/**
 * @author zhibin.wang
 * @create 2019-07-10
 * @desc 策略模式接口
 **/
public interface Conparator<T> {

    int compare(T t1,T t2);
}
