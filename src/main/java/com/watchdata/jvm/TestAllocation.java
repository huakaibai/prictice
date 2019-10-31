package com.watchdata.jvm;

/**
 * @author zhibin.wang
 * @create 2019-10-30 17:34
 * @desc 测试java内存回收，-verbose:gc -Xms                                  20M -Xmx20M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 **/


public class TestAllocation {

    private static  final int _1MB = 1024 * 2024;

    public static void main(String[] args) {
        byte[] all1 ,all2,all3,all4;
        all1 = new byte[2 * _1MB];
        all2 = new byte[2 * _1MB];
        all3 = new byte[3 * _1MB];

    }
}
