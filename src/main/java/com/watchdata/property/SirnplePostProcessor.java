package com.watchdata.property;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zhibin.wang
 * @create 2019-06-05 12:05
 * @desc
 **/
public class SirnplePostProcessor {


    private String userName;

    private String passwd;

    private String other;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "SirnplePostProcessor{" +
                "userName='" + userName + '\'' +
                ", passwd='" + passwd + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ConfigurableListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("application-propertyEdtior.xml"));
      BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor)bf.getBean("bfpp");
      bfpp.postProcessBeanFactory(bf);
      System.out.println(bf.getBean("simpleBean"));

    }
}
