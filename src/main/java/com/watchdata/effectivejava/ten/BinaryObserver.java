package com.watchdata.effectivejava.ten;

/**
 * @author zhibin.wang
 * @create 2019-07-17 16:33
 * @desc
 **/
public class BinaryObserver extends  AbstractObserver {

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update(int state) {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
