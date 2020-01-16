package com.johnabbott.corebanking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.corebanking.dao.AccountDao;

import com.johnabbott.corebanking.model.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Override
	public boolean openAccount(Account account) {
		return accountDao.insertAccount(account);
	}

	@Override
	public List<Account> getAccounts() {
		return accountDao.getAccounts();
	}

	@Override
	public Account getAccountById(int accountId) {
		return accountDao.getAccountById(accountId);
	}

	@Override
	public boolean closeAccount(int accountId) {
		return accountDao.deleteAccount(accountId);
	}

	@Override
	public boolean updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}

	@Override
	public List<Account> getAccountsByCustomerId(int customerId) {
		return accountDao.getAccountsByCustomerId(customerId);
	};

}
