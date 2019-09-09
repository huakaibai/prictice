package com.watchdata.effectivejava.four;

/**
 * @author zhibin.wang
 * @create 2019-07-10 14:39
 * @desc 测率模式宿主类
 **/
public class Host {


    // 定义公用的比较类
    public static StrLenCmp STR_LEN_CMP = new StrLenCmp();

    // 策略模式具体实现类
    private static  class StrLenCmp implements  Conparator<String>{
        @Override
        public int compare(String t1, String t2) {
            return t1.length() - t2.length();
        }
    }


}
