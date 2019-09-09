package com.watchdata.aspect;

import com.watchdata.property.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhibin.wang
 * @create 2019-06-05 16:04
 * @desc
 **/
public class TestBean {

    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }


    public void test(){
        System.out.println("test");
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:application-propertyEdtior.xml");
        TestBean bean = ctx.getBean(TestBean.class);
        bean.test();
    }
}
