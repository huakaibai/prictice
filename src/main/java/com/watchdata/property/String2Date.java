package com.watchdata.property;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhibin.wang
 * @create 2019-06-05 15:16
 * @desc
 **/
public class String2Date implements Converter<String, Date> {

    private String format = "yyyy-MM-dd";


    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return date;
    }



        public static void main(String[] args) {
//            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:application-propertyEdtior.xml");
//            User bean = ctx.getBean(User.class);
//            System.out.println(bean.getDateValue());


            DefaultConversionService conversionService = new DefaultConversionService();
            conversionService.addConverter(new String2Date());

            String date = "2019-02-03";

            Date date1 = conversionService.convert(date,Date.class);
            System.out.println(date1);
        }

}
