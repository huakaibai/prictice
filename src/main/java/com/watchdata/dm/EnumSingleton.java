package com.watchdata.dm;

/**
 * @author 花开
 * @create 2019-12-21 23:51
 * @desc 枚举单列模式
 **/
public class EnumSingleton {

    private  EnumSingleton(){}

    static enum Sigleton{
        INSTANCE;

        private EnumSingleton enumSingleton;

        Sigleton() {
            enumSingleton = new EnumSingleton();
        }

        public EnumSingleton getEnumSingleton() {
            return enumSingleton;
        }


    }

    public static void main(String[] args) {
        EnumSingleton enumSingleton = Sigleton.INSTANCE.getEnumSingleton();
        EnumSingleton enumSingleton2 = Sigleton.INSTANCE.getEnumSingleton();
        System.out.println(enumSingleton == enumSingleton2);
    }
}
