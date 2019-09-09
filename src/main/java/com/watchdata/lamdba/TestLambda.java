package com.watchdata.lamdba;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhibin.wang
 * @create 2019-09-03 13:47
 * @desc
 **/
public class TestLambda {

    public static void main(String[] args) {

        /**
         *  lambda 写内部类
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("传动方式");
            }
        }).start();

        // 只能是一个语句吗？
        new Thread(()-> System.out.println("lambda fangshi ")).start();


        System.out.println("-------------");
        /**
         * 对集合进行迭代
         */

       List<String> languages = Arrays.asList("java","scala","python");
        for (String language : languages) {
            System.out.println(language);
            System.out.println("传统方式迭代集合");
        }

        System.out.println("-------------");

        languages.forEach(x -> System.out.println(x));
        languages.forEach(System.out::println);
        System.out.println("-------------");

        /**
         * 对map集合
         */

        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        cost.stream().map(x -> x+x*0.5).forEach(System.out::println);
    }
}
