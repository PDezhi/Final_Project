package com.johnabbott.corebanking.dao;

import java.util.List;

import com.johnabbott.corebanking.model.Customer;

public interface CustomerDao {

	//insert
	public boolean insertCustomer(Customer customer); 
	
	//Read
	public List<Customer> getCustomers(); 
	public Customer getCustomerById(int customerId); 
		
	//DELETE
	public boolean deleteCustomer(int customerId); 
	
	// UPDATE
	public boolean updateCustomer(Customer customer); 


}
