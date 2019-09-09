package com.watchdata.effectivejava.five;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhibin.wang
 * @create 2019-07-10 16:57
 * @desc
 **/
public class Type {

    public static void main(String[] args) {
        List<String>[] lsits = new List[1]; // 这样会有类型安全检查警告
    }
}
