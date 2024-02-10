package com.hibernet.hiberner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernet.hiberner.entity.Accounts;
import com.hibernet.hiberner.repository.AccountDao;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountRepository;

	public Accounts createAccount(Accounts acc) {
		return accountRepository.createAccount(acc);
	}

	public boolean updateAccountBalance(Long accId, Long balance) {
		return accountRepository.updateAccountBalance(accId, balance);
	}

	public boolean deleteAccount(Long accId) {
		return accountRepository.deleteAccount(accId);
	}
}
