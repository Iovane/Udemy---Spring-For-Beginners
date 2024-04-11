package practice.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(this.getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* practice.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    // do the same for service and dao
    @Pointcut("execution(* practice.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* practice.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void logBefore(JoinPoint joinPoint) {

        // display method we are calling
        String methodName = joinPoint.getSignature().toShortString();
        myLogger.info("====>> in @Before: calling method: " + methodName);

        // display the argument to the method

        // get the arguments
        Object[] args = joinPoint.getArgs();

        // loop thru and display args
        for (Object tempArg : args) {
            myLogger.info("====>> argument: " + tempArg);
        }
    }

    // add @AfterReturning advice

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint joinPoint, Object theResult) {

        // display method we are returning from
        String methodName = joinPoint.getSignature().toShortString();
        myLogger.info("====>> in @AfterReturning: calling method: " + methodName);

        // display data returned
        myLogger.info("====>> Result: " + theResult);
    }
}
