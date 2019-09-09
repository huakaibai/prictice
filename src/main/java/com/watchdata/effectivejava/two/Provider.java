package com.watchdata.effectivejava.two;

/**
 * @author zhibin.wang
 * @create 2019-07-09 10:10
 * @desc 服务提供者
 **/
public interface Provider extends   Service {

  Service newService();
}
