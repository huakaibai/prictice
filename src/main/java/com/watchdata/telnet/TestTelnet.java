package com.watchdata.telnet;

import org.apache.commons.net.telnet.TelnetClient;

import java.io.IOException;

/**
 * @author zhibin.wang
 * @desc 测试telnet commaon-net
 **/
public class TestTelnet {

    public static void main(String[] args) {
        TelnetClient telnetClient = new TelnetClient();
        telnetClient.setConnectTimeout(1000);

        try {
            telnetClient.connect("10.0.111.13", 3306);
            System.out.println("telnet 成功");
            telnetClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("连接服务器失败1");
        }

    }
}
