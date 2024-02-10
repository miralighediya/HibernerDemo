package com.hibernet.hiberner;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hibernet.hiberner.config.AppConfig;
import com.hibernet.hiberner.entity.Accounts;
import com.hibernet.hiberner.service.AccountService;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AccountService accountService = context.getBean(AccountService.class);
		// ProfileService profileService = context.getBean(ProfileService.class);
		SessionFactory sessionFactory = context.getBean(SessionFactory.class);
		// System.out.println(sessionFactory.openSession().get(Account.class,"Mira"));
		// Profile p = sessionFactory.openSession().get(Profile.class, 101010L);
		Accounts acc = new Accounts();
		acc.setName("Nilk");
		acc.setBalance(101010L);
		System.out.println(accountService.createAccount(acc));
		System.out.println(accountService.updateAccountBalance(2L,31L));
//		System.out.println(accountService.deleteAccount(1L));
	}
}
