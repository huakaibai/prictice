package com.watchdata.effectivejava.eight;

/**
 * @author zhibin.wang
 * @desc
 **/
public class DoubleAndBigDecimal {

    public static void main(String[] args) {
        doub();
    }


    public static void doub(){

        double founds = 1.00;
        int itemBought = 0;

        for (double price = .10; founds > price;price += .10){
            founds -= price;
            itemBought++;
        }

        System.out.println("itemBought:"+itemBought);
        System.out.println("change:$"+founds);
    }



}
