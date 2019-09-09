package com.watchdata.property;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author zhibin.wang
 * @create 2019-06-03 11:40
 * @desc
 **/
public class User {

	private Date dateValue;

	public Date getDateValue() {
		return dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:application-propertyEdtior.xml");
		User bean = ctx.getBean(User.class);
		System.out.println(bean.getDateValue());
	}
}
