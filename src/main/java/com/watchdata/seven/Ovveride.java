package com.watchdata.seven;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhibin.wang
 * @create 2019-07-16 14:56
 * @desc
 **/
public class Ovveride {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3;i < 3;i++){
            set.add(i);
            list.add(i);
        }
        System.out.println(set + " " +list
        );
        for (int i = 0;i < 3;i++){
            set.remove(i);
            list.remove(i);
        }

        System.out.println(set + " " +list
        );
    }
}
