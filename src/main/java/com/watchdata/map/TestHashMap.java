package com.watchdata.map;

/**
 * @author 花开
 * @create 2020-05-21 21:33
 * @desc 测试hashmap 扩容
 **/
public class TestHashMap {

    public static void main(String[] args) {

        String aa = "key.hashCode()) ^ (h >>> 16)";
        String bb = "232";
        int i = (bb.hashCode()) ^ (bb.hashCode() >>> 16);
        System.out.println(i);
        int i1 = 15 & i;
        System.out.println(i1);

        int i2 = 31 & i;
        System.out.println(i2);
    }


    public void  test(){

        synchronized (TestHashMap.class){

        }
    }
}
