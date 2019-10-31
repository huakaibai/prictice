package com.watchdata.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhibin.wang
 * @create 2019-10-18 17:35
 * @desc -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 **/
public class HeapOOM {

    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
