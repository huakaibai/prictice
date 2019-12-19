package com.watchdata.tryfinaly;

/**
 * @author zhibin.wang
 * @create 2019-12-19 14:27
 * @desc try{}里有一个return语句，那么紧跟在这个try后的finally{}里的代码会不会被执行，什么时候被执行，在return前还是后?
 * 答：会执行，在方法返回调用者前执行
 **/
public class TestMain {


    public static void main(String[] args) {

        System.out.println(test());
    }

    public static String test(){

        try {

            return "a";
        }finally {
            return "b";
        }
    }
}
