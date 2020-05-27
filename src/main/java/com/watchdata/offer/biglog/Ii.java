package com.watchdata.offer.biglog;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author 花开
 * @create 2020-05-23 18:58
 * @desc 测试compareable
 **/
@AllArgsConstructor
@Data
public class Ii implements Comparable<Ii> {

    private String str;

    private int i;


    @Override
    public int compareTo(Ii o) {
        if (this == o){
            return 0;
        }

        if (str.equals(o.getStr())){
            i = o.getI() + i;
            o.setI(i);
            return 0;
        }
        if (i >= o.getI()){
            return -1;
        }else {
            return 1;
        }

    }


    public static void main(String[] args) {
        Set<Ii> set = new TreeSet<>();

        set.add(new Ii("aa",1));
        set.add(new Ii("aa",1));
        set.add(new Ii("aa",1));
        set.add(new Ii("cc",1));

        for (Ii ii : set) {
            System.out.println(ii);
        }
    }
}
