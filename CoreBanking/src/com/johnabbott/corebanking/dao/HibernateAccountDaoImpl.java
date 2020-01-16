package com.johnabbott.corebanking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.corebanking.model.Account;


@Repository
public class HibernateAccountDaoImpl implements AccountDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insertAccount(Account account) {
		getSession().save(account);
		getSession().save(account.getInterest());
		return true;
	}

	@Override
	public List<Account> getAccounts() {
		return getSession().createQuery("from Account", Account.class).list();
	}

	@Override
	public List<Account> getAccountsByCustomerId(int customerId) {
		String hql = "from Account where customerId = :customerId";
		Query query = getSession().createQuery(hql);
		query.setParameter("customerId", customerId);
		if (query.list().size() > 0) {
			return (List<Account>)query.list();
		}
		else {
			return null;
		}
	}

	@Override
	public Account getAccountById(int accountId) {
		return getSession().get(Account.class, accountId);
	}

	@Override
	public boolean deleteAccount(int accountId) {
		Account fetchedAccount = getAccountById(accountId);
		getSession().delete(fetchedAccount);
		return true;
	}

	@Override
	public boolean updateAccount(Account account) {
		getSession().update(account);
		return true;
	}
	

	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

}
