package com.practice.aopdemo;

import com.practice.aopdemo.dao.AccountDAO;
import com.practice.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao, MembershipDAO theMembershipDao) {

		return runner -> {
		
		demoTheBeforeAdvice(theAccountDao, theMembershipDao);
		
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao, MembershipDAO theMembershipDao) {

		// call the business method
		theAccountDao.addAccount(new Account(), false);
		theAccountDao.doWork();

		// call the membership business method
		theMembershipDao.addSillyMember();
		theMembershipDao.goToSleep();


	}

}
