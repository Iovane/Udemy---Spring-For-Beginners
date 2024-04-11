package com.practice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {

    @Before("com.practice.aopdemo.aspect.PracticeAopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync(){
        System.out.println("\n======>>>>> Logging to Cloud in async fashion <<<<<======");
    }
}
