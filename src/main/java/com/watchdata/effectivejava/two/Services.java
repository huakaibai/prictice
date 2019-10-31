package com.watchdata.effectivejava.two;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhibin.wang
 * @create 2019-07-09 10:10
 * @desc 服务注册管理
 **/
public class Services {

    private Services() {};

     private static Map<String,Provider> providers = new ConcurrentHashMap<>();

    private static final String DEFAULT_PROVIDER_NAME = "<def>";


    public static void registerDefaultProvider(Provider provider){
        registerProvider(DEFAULT_PROVIDER_NAME,provider);
    }

    public static void registerProvider(String name,Provider provider){
        providers.put(name,provider);
    }

    public static Service newInstance(){
        return  newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        Provider provider = providers.get(name);
        if (provider == null){
            throw new IllegalArgumentException("No provider with name:"+name);
        }
        return provider.newService();
    }


}
