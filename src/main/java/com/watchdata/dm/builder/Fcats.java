package com.watchdata.dm.builder;

import lombok.Data;

/**
 * @author zhibin.wang
 * @desc
 **/
@Data
public class Fcats {

    private  int servingSize;

    private int servings;

    private int calories;

    private int fat;

    private int sodium;

    private int carbohydrate;


    public static  class Builder{

        private  int servingSize;

        private int servings;

        private int calories;

        private int fat;

        private int sodium;

        private int carbohydrate;


        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder Calories(int calories){
            this.calories = calories;
            return this;
        }

        public Builder Fat(int fat){
            this.fat = fat;
            return this;
        }

        public Builder Sodium(int sodium){
            this.sodium = sodium;
            return this;
        }

        public Builder CarHohydrate(int carbohydrate){
            this.carbohydrate = carbohydrate;
            return this;
        }

        public Fcats builder(){
            return new Fcats(this);
        }


    }


    private Fcats(Builder builder){

        this.calories = builder.calories;
        this.carbohydrate = builder.carbohydrate;
        this.fat = builder.fat;
        this.servings = builder.servings;
        this.servingSize = builder.servingSize;
    }



}
