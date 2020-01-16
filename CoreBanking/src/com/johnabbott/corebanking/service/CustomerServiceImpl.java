package com.johnabbott.corebanking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.corebanking.dao.CustomerDao;
import com.johnabbott.corebanking.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{


	@Autowired
	CustomerDao customerDao;

	
	@Override
	public boolean addCustomer(Customer customer) {
		return customerDao.insertCustomer(customer);
	}

	@Override
	public List<Customer> getCustomers() {

		return customerDao.getCustomers();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return customerDao.deleteCustomer(customerId);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	

}
