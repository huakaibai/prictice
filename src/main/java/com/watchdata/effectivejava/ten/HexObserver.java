package com.watchdata.effectivejava.ten;

/**
 * @author zhibin.wang
 * @create 2019-07-17
 * @desc
 **/
public class HexObserver extends  AbstractObserver {


    public HexObserver(Subject subject) {
        super(subject);

    }


    @Override
    public void update(int state) {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
