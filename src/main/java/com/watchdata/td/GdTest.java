package com.watchdata.td;

import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhibin.wang
 * @desc 测试反射获取与属性
 **/
@Data
public class GdTest {

    @lombok.Data
    static  class Data{

        private String iccid;

        private String imsi;

    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Data data = new Data();

        //data.setIccid("123");
        data.setImsi("234");
        String fileed = "Iccid";

        Class<? extends Data> aClass = data.getClass();
        Method declaredMethod = aClass.getDeclaredMethod("get" + "Iccid");
        String invoke = (String)declaredMethod.invoke(data);
        if (invoke == null || "".equals(invoke)){
            System.out.println("_-------------");
        }
        System.out.println(invoke);

        String aa = "00319,00320,00321";
        System.out.println(aa.indexOf("003257"));

        Data cc = (Data) getObject();
    }
   // private boolean isRoam4gData(Data data,String filed)


    public static Object getObject(){
        Data data = null;
        return data;
    }

}
