package com.watchdata.jvm;

/**
 * @author zhibin.wang
 * @create 2019-10-30
 * @desc 测试java内存回收，-verbose:gc -Xms                                  20M -Xmx20M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 **/


public class TestAllocation {

    private static  final int _1MB = 1024 * 2024;

    public static void main(String[] args) {
        testPretenureSizeThreshold();

    }

    /**
     * 测试大对象直接分配到老年代
     * -verbose:gc -Xms                                  20M -Xmx20M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3M  -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCDateStamps -Xloggc:gclog.log 设置直接分配大对象大小
     */
    public static  void testPretenureSizeThreshold(){
        byte[] all1 ;
        all1 = new byte[4 * _1MB];
    }

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static  void  testAllocation(){
        byte[] all1 ,all2,all3,all4;
        all1 = new byte[2 * _1MB];
        all2 = new byte[2 * _1MB];
        all4 = new byte[2 * _1MB];
        all3 = new byte[4 * _1MB];
    }
}
