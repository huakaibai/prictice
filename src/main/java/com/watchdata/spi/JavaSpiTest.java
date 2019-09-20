package com.watchdata.spi;

import java.util.ServiceLoader;

/**
 * @author zhibin.wang
 * @create 2019-09-20 9:33
 * @desc
 **/

public class JavaSpiTest {

    public static void main(String[] args) {
        ServiceLoader<Robot> load = ServiceLoader.load(Robot.class);

        load.forEach(Robot::sayHello);
    }
}
