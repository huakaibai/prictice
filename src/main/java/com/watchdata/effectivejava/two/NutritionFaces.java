package com.watchdata.effectivejava.two;

/**
 * @author zhibin.wang
 * @create 2019-07-09 10:34
 * @desc
 **/
public class NutritionFaces {

    private int servingSize;

    private  int servings;

    private  int calories;

    private  int fat;

    private  int sodium;

    private  int carbohydrate;

    public static class Builder{

        private  int servingSize;

        private  int servings;

        private  int calories = 0;

        private  int fat = 0;

        private  int sodium = 0;

        private  int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public  Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder fat(int val){
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val){

            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val){
            sodium = val;
            return this;
        }

        public NutritionFaces build(){
            return new NutritionFaces(this);
        }
    }

    public  NutritionFaces(Builder builder){
        servings = builder.servings;
        servingSize = builder.servingSize;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFaces cacacola = new Builder(240,8).calories(100)
                .calories(10).build();
    }
}