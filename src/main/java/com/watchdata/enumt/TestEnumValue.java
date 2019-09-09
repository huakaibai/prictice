package com.watchdata.enumt;

/**
 * @author zhibin.wang
 * @create 2019-07-02 10:39
 * @desc
 **/
public enum TestEnumValue {

    MON(1),TUE(2),WED(3),THU(4),FRI(5),SAT(6){

        public  boolean isRest(){
            return true;
        }
    },SUN(0){
        public  boolean isRest(){
            return true;
        }
    };

    private int value;

    private TestEnumValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isRest(){
        return false;
    }
}
