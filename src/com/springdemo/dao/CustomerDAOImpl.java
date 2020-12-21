package com.springdemo.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		Session current= sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = current.createQuery("from Customer order By lastName",Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
				
	   Session session = sessionFactory.getCurrentSession();
	   session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {

		Session current = sessionFactory.getCurrentSession();
		Customer theCustomer = current.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session current = sessionFactory.getCurrentSession();
		Query theQuery = current.createQuery("delete from Customer where id=:customerId ");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}

}
