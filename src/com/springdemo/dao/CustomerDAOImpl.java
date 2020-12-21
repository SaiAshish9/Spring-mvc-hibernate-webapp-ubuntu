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
		
		Query<Customer> theQuery = current.createQuery("from Customer",Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

}
