package com.hibernet.hiberner.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernet.hiberner.entity.Accounts;

@Repository
public class AccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Accounts createAccount(Accounts acc) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(acc);
		t.commit();
		System.out.println("New account created successfully");
		session.close();

		return acc;
	}

	public boolean updateAccountBalance(Long accId, Long balance) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Accounts acc = session.get(Accounts.class, accId);
		acc.setBalance(balance);
		session.save(acc);
		t.commit();
		System.out.println("Account updated successfully");
		session.close();
		return true;
	}

	public boolean deleteAccount(Long accId) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Accounts acc = session.get(Accounts.class, accId);
		session.delete(acc);
		t.commit();
		System.out.println("Account deleted successfully");
		session.close();
		return true;
	}
}
