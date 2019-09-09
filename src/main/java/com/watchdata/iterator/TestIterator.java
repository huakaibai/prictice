package com.watchdata.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhibin.wang
 * @create 2019-07-04 13:51
 * @desc
 **/
public class TestIterator {

    public static void main(String[] args) {

        List<String> list = new ArrayList();

        list.add("33");
        list.add("44");
        list.add("55");

        for (String string:list
             ) {
            System.out.println("xunhuan="+string
            );
            if ("33".equals(string)){
                System.out.println("remove");
                list.remove(string);
            }
        }
    }
}
