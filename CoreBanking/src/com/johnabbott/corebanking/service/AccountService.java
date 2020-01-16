package com.johnabbott.corebanking.service;

import java.util.List;

import com.johnabbott.corebanking.model.Account;

public interface AccountService {

	// Open an account.
	public boolean openAccount(Account acc);
	
	// Get accounts list
	public List<Account> getAccounts(); 
	
	// Get account by accountId
	public Account getAccountById(int accountId);
	
	// Close an account
	public boolean closeAccount(int accountId); 
	
	// update an account
	public boolean updateAccount(Account acc); 

	// update an account
	public List<Account> getAccountsByCustomerId(int customerId) ; 
}
