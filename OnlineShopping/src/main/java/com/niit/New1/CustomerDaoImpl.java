package com.niit.New1;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Authorities;
import com.niit.Model.Customer;

	
	
	@Repository
	@Transactional
	public class CustomerDaoImpl implements CustomerDao {
		@Autowired
	private SessionFactory sessionFactory;
		public void registerCustomer(Customer customer) {
		   Session session=sessionFactory.getCurrentSession();
		   
		   //SET ENABLED property in USER as true
		   customer.getUser().setEnabled(true);
		   
		   System.out.println(customer.getUser().getAuthorities());
		   
		   //CREATE new AUTHORITIES OBJECT AND SET THE ROLE AS ROLE_USER
		   Authorities authorities=new Authorities();
		   authorities.setRole("ROLE_USER");
		   //AUTHORITIES PROPERTY IN USER REFERS TO AUTHORITIES OBJECT
		   customer.getUser().setAuthorities(authorities);
		   
		   //MAKE USER PROPERTY IN AUTHORITIES TO REFER USER OBJECT
		   authorities.setUser(customer.getUser());
		   
		   
		   session.save(customer);
		   //has to insert into customer table
		}

	}

