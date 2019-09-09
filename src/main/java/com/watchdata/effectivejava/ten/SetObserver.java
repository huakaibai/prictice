package com.watchdata.effectivejava.ten;

/**
 * @author zhibin.wang
 * @create 2019-07-17 15:37
 * @desc
 **/
public interface SetObserver<E> {

    void added(ObservableSet<E> set ,E element);
}
