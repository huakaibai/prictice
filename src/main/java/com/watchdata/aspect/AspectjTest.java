package com.watchdata.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author zhibin.wang
 * @create 2019-06-05
 * @desc
 **/
@Aspect
public class AspectjTest {

    @Pointcut("execution(* *.test(..))")
    public  void test(){}


    @Before("test()")
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @After("test()")
    public void afterTest(){
        System.out.println("afterTest");
    }

    @Around("test()")
    public Object arroundTest(ProceedingJoinPoint p){

        System.out.println("before1");

        Object proceed = null;
        try {
            proceed = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("after1");

        return proceed;
    }
}
