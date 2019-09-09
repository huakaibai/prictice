package com.watchdata.effectivejava.four;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhibin.wang
 * @create 2019-07-10 11:13
 * @desc 具体的装饰类
 **/
public class InstrumentedSet<E> extends  ForwardingSet<E> {

    private int addCount = 0;

    public InstrumentedSet(Set<E> set) {
        super(set);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        System.out.println(addCount);
        return super.add(e);
    }

    public static void main(String[] args) {
        Set<String> reallySet = new HashSet<>();


        Set<String> sets = new InstrumentedSet<String>(reallySet);

        sets.add("12");
        sets.add("123");
    }
}
