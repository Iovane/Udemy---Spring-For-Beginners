package com.practice.aopdemo;

import com.practice.aopdemo.dao.AccountDAO;
import com.practice.aopdemo.dao.MembershipDAO;
import com.practice.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao,
											   MembershipDAO theMembershipDao,
											   TrafficFortuneService theTrafficFortuneService) {

		return runner -> {
		
//		demoTheBeforeAdvice(theAccountDao, theMembershipDao);

//			demoTheAfterReturningAdvice(theAccountDao);

//			demoTheAfterThrowingAdvice(theAccountDao);

//			demoTheAfterAdvice(theAccountDao);

//			demoTheAroundAdvice(theTrafficFortuneService);

//			demoTheAroundHandleException(theTrafficFortuneService);

			demoTheAroundAdviceRethrowException(theTrafficFortuneService);

		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundHandleException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundHandleException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundHandleException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");

	}

	private void demoTheAfterAdvice(AccountDAO theAccountDao) {

		// call method to find the theAccounts
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = theAccountDao.findAccounts(tripWire);

		} catch (Exception exc) {
			System.out.println("\n\nMain Program: caught exception: " + exc);
		}

		// display the theAccounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDao) {

		// call method to find the theAccounts
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDao.findAccounts(tripWire);

		} catch (Exception exc) {
			System.out.println("\n\nMain Program: caught exception: " + exc);
		}

		// display the theAccounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");

	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDao) {

		// call method to find the accounts
		List<Account> accounts = theAccountDao.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(accounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao, MembershipDAO theMembershipDao) {

		Account myAccount = new Account();
		myAccount.setName("Mamasita");
		myAccount.setLevel("Didtraka");

		// call the business method
		theAccountDao.addAccount(myAccount,true);
		theAccountDao.doWork();
		theAccountDao.setName("Mamasita");
		theAccountDao.setServiceCode("13456");
		theAccountDao.getName();
		theAccountDao.getServiceCode();

		// call the membership business method
		theMembershipDao.addSillyMember();
		theMembershipDao.goToSleep();


	}

}
