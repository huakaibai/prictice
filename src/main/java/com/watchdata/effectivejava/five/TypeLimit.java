package com.watchdata.effectivejava.five;

import java.util.Iterator;
import java.util.List;

/**
 * @author zhibin.wang
 * @create 2019-07-11 10:40
 * @desc 泛型方法类型限制
 *  E 称为类型参数
 *  ？ 成为通配符
 **/
public class TypeLimit {


/*    public static  <T extends  Comparable<T> > T max(List<T> list){
         Iterator<T> i =  list.iterator();
         T result = i.next();
         while (i.hasNext()){
             T t = i.next();
             if (t.compareTo(result) > 0)
                 result = t;
         }
         return result;
    }*/

// 优化版本
    public static <T extends  Comparable<? super  T>> T max(List<? extends  T> list){
        Iterator<? extends T> iterator = list.iterator();
        T result = iterator.next();
        while (iterator.hasNext()){
            T t = iterator.next();
            if (t.compareTo(result) > 0)
                result = t;

        }
        return result;
    }
}
