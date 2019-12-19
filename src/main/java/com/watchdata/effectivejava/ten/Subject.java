package com.watchdata.effectivejava.ten;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhibin.wang
 * @desc 观察者模式
 **/
public class Subject {


    private final List<Observer> list = new ArrayList<>();

    private int state;


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObserver();
    }

    public void attach(Observer observer){
        list.add(observer);


    }


    public void notifyObserver(){

        for (Observer ob:list
             ) {
            ob.update(state);
        }
    }


    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer a = new HexObserver(subject);
        Observer b = new BinaryObserver(subject);

        subject.setState(10);
    }
}
