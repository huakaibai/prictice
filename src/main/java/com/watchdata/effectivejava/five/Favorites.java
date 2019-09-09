package com.watchdata.effectivejava.five;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhibin.wang
 * @create 2019-07-11 11:50
 * @desc
 **/
public class Favorites {

    private Map<Class<?>,Object> favorites = new HashMap<>();

    //<T> 用来形容修饰后面参数中的T，没有这个<T> 则编译报错
    public <T> void put(Class<T> type,T instance){
        if (type == null)
            throw new NullPointerException("Type is null");
        favorites.put(type,instance);
    }


    public <T> T get(Class<T> type){
        Object o = favorites.get(type);
        return  type.cast(o);

    }
}
