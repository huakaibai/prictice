package com.watchdata.enumt;

import java.util.*;

/**
 * @author zhibin.wang
 * @create 2019-07-02 10:23
 * @desc
 **/
public class Test {


    public static void main(String[] args) {
        for (TestEnum e : TestEnum.values()) {
            System.out.println(e.toString());
        }


        System.out.println("------------------------------------");

        TestEnum test = TestEnum.TUE;

        switch (test) {
            case MON:
                System.out.println("星期一");
                break;
            case TUE:
                System.out.println("星期二");
                break;
            default:
                System.out.println(test);
                break;
        }

        switch (test.compareTo(TestEnum.MON)) {
            case -1:
                System.out.println("Tue 在 Mon 之前");
                break;
            case 1:
                System.out.println("Tue 在 Mon 之后");
                break;
            default:
                System.out.println("在同一位置");
                break;

        }
        System.out.println("getDeclaringClass()" + test.getDeclaringClass().getName());
        System.out.println("name()" + test.toString());

        // 在枚举中的顺序值
        System.out.println("ordinal：" + test.ordinal());


        System.out.println("FRI="+TestEnumValue.FRI.getValue() +" ordinal == "+TestEnumValue.FRI.ordinal());// 单独设定value


        // EnumSet EnumMap
        System.out.println("------------------SET--------------------------");
        EnumSet<TestEnumValue> weekset = EnumSet.allOf(TestEnumValue.class);
        for (TestEnumValue day : weekset
        ) {
            System.out.println(day);
        }


        System.out.println("------------------map--------------------------");

        Map<TestEnumValue,String> map = new HashMap<TestEnumValue, String>();
        Set<Map.Entry<TestEnumValue, String>> entries = map.entrySet();
        for (Map.Entry<TestEnumValue, String> entry : entries) {
            entry.getKey();

        }

        map.put(TestEnumValue.FRI,"星期一");
        Iterator<Map.Entry<TestEnumValue, String>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<TestEnumValue, String> next = iterator1.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }


        System.out.println("------------------enummap--------------------------");
        //EnumMap
        EnumMap<TestEnumValue, String> wekMap = new EnumMap<TestEnumValue, String>(TestEnumValue.class);
        wekMap.put(TestEnumValue.MON, "星期一");
        wekMap.put(TestEnumValue.FRI, "星期五");

        Iterator<Map.Entry<TestEnumValue, String>> iterator = wekMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<TestEnumValue, String> next = iterator.next();
            System.out.println(next.getKey()+" value="+next.getValue());
        }

        // isRest
        System.out.println(TestEnumValue.FRI.isRest());

    }
}
