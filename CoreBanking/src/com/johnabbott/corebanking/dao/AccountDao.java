package com.johnabbott.corebanking.dao;

import java.util.List;

import com.johnabbott.corebanking.model.Account;

public interface AccountDao {

	//insert
	public boolean insertAccount(Account account); 
	
	//Read
	public List<Account> getAccounts(); 
	public Account getAccountById(int accountId); 
		
	//DELETE
	public boolean deleteAccount(int accountId); 
	
	// UPDATE
	public boolean updateAccount(Account account); 

	public List<Account> getAccountsByCustomerId(int customerId);

	
}
