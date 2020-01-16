package com.johnabbott.corebanking.service;

import java.util.List;

import com.johnabbott.corebanking.model.Customer;

public interface CustomerService {

	// Add an new customer.
	public boolean addCustomer(Customer acc);
	
	// Get a list of customers
	public List<Customer> getCustomers(); 
	
	// Get a customer by customerId
	public Customer getCustomerById(int customerId);
	
	// Delete the customer by customerId
	public boolean deleteCustomer(int customerId); 
	
	// update an customer
	public boolean updateCustomer(Customer acc);

}
