package com.watchdata.effectivejava.ten;

/**
 * @author zhibin.wang
 * @desc
 **/
public interface SetObserver<E> {

    void added(ObservableSet<E> set ,E element);
}
