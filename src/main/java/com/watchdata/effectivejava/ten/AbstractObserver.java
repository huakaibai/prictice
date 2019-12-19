package com.watchdata.effectivejava.ten;

/**
 * @author zhibin.wang
 * @create 2019-07-17
 * @desc
 **/
public abstract class AbstractObserver implements  Observer {

    protected Subject subject;

    public AbstractObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }


}
