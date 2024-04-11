package com.practice.aopdemo.aspect;

import com.practice.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Around("execution(* com.practice.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        // print out which method we are advising on
        String methodName = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @Around on method: " + methodName);

        // get begin timestamp
        long startTime = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;
        try {
           result = theProceedingJoinPoint.proceed();

        } catch (Exception exc) {

            // loge the exception
            System.out.println(exc.getMessage());

            // rethrow exception
            throw exc;
           }

        // get end timestamp
        long endTime = System.currentTimeMillis();

        // compute duration and display it
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration / 1000.0 + " seconds");

        return result ;
    }

    @After("execution(* com.practice.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        // print out which method we are advising on
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @After (finally) on method: " + methodName);
    }

    @AfterThrowing(
            pointcut = "execution(* com.practice.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice( JoinPoint joinPoint, Throwable theExc){

        // print out which method we are advising on
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @AfterThrowing on method: " + methodName);

        // log the exception
        System.out.println("\n=====>>>> The Exception is: " + theExc);

    }

    // add a new advice for @AfterReturning on the find Accounts method
    @AfterReturning(
            pointcut = "execution(* com.practice.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, List<Account> result) {

        // print out which method we are advising on
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @AfterReturning on method: " + methodName);

        // print out the result of the method call
        System.out.println("\n=====>>>> result is: " + result);

        // let's post-process the data, let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>>> result is: " + result);


    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for (Account tempAccount : result) {

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);

        }
    }

    @Before("com.practice.aopdemo.aspect.PracticeAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n======>>>>> executing @Before advice on method <<<<<======");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg : args) {
            System.out.println("arg: " + tempArg);

            if (tempArg instanceof Account) {

                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

}
