package com.watchdata.effectivejava.sex;

/**
 * @author zhibin.wang
 * @create 2019-07-15 10:52
 * @desc 看一下tostring的用法
 **/
public enum Operation {


    PLUS("+"){
      double  apply(double x, double y){
          return x + y;
      }
    },MINUS("-"){
        double  apply(double x, double y){
            return x - y;
        }
    },TIMES("*"){
        double  apply(double x, double y){
            return x * y;
        }
    },DIVIDE("/"){
        double  apply(double x, double y){
            return x / y;
        }
    };

    private final String symbol;
    Operation(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
       return symbol;
    }

    abstract  double apply(double x, double y);

    public static void main(String[] args) {
        double x = 2.0;
        double y = 4.0;

        for (Operation operation:Operation.values()
             ) {
            System.out.printf("%f %s %f = %f%n",x,operation,y,operation.apply(x,y));
        }
    }
}
