package com.watchdata.offer.biglog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.*;

/**
 * @author 花开
 * @create 2020-05-22 22:47
 * @desc IP 从日志中，筛选排名前一百得得ip
 **/
@Data
@AllArgsConstructor
@ToString
public class IP implements  Comparable<IP> {

    private String ip;

    private int num;

    @Override
    public int compareTo(IP o) {
        if (this == o){
            return 0;
        }
        if (this.ip.equals(o.getIp())){
            this.num = this.num + o.getNum();
            o.setNum(num);
            return 0;
        }
        if (this.num > o.getNum()  ){
            return  -1;
        }
        else{
            return 1;
        }

    }


    public static void main(String[] args) {
       // List<IP> list = new ArrayList<>();
        Set<IP> set = new TreeSet<>();
    /*    set.add(new IP("192",1));
        set.add(new IP("192",1));
        set.add(new IP("192",1));
        set.add(new IP("192",1));*/
        set.add(new IP("192",1));
        set.add(new IP("192",1));
        set.add(new IP("193",1));
        set.add(new IP("192",1));
        set.add(new IP("192",1));
        set.add(new IP("194",1));
        set.add(new IP("193",1));


        for (IP ip : set) {
            System.out.println(ip);
        }
    }
}
