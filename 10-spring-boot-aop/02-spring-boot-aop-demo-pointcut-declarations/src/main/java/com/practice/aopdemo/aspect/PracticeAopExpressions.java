package com.practice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PracticeAopExpressions {

    @Pointcut("execution(* com.practice.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // create pointcut for getter methods
    @Pointcut("execution(* com.practice.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* com.practice.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // combine pointcut: include package and exclude getter/setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
