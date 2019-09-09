package com.watchdata.testswitch;

/**
 * @author zhibin.wang
 * @create 2019-07-08 9:57
 * @desc 当 switch 括号内的变量类型为 String 并且此变量为外部参数时，必须先进行 null
 * 判断。
 **/
public class TestSwitch {


    public static void method(String param){
        switch (param){ // 会在这里paochu空指针异常

            case "sh":
                System.out.println("it is sh");
                break;
            case "null":
                System.out.println("it is null");
                break;
            default:
                break;

        }
    }

    public static void main(String[] args) {
        method(null);
    }
}
