package com.johnabbott.corebanking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.corebanking.model.Customer;

@Repository
public class HibernateCustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insertCustomer(Customer customer) {
		getSession().save(customer);
		return true;
	}

	@Override
	public List<Customer> getCustomers() {
		return getSession().createQuery("from Customer", Customer.class).list();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return getSession().get(Customer.class, customerId);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		Customer fetchedCustomer = getCustomerById(customerId);
		getSession().delete(fetchedCustomer);
		return true;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		getSession().update(customer);
		return true;
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

}
