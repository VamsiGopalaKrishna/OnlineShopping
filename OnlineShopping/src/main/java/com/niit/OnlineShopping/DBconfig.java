package com.niit.OnlineShopping;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Model.Authorities;
import com.niit.Model.BillingAddress;
import com.niit.Model.CartItem;
import com.niit.Model.Category;
import com.niit.Model.Customer;
import com.niit.Model.CustomerOrder;
import com.niit.Model.Product;
import com.niit.Model.ShippingAddress;
import com.niit.Model.User;

@Configuration
@EnableTransactionManagement
public class DBconfig {
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/niit");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		return dataSource;
	}
	
	public DBconfig(){
		System.out.println("DBConfiguration bean is created");
	}
	
	@Bean
	public SessionFactory sessionFactory()
	{
		System.out.println("Entering sessionFactory creation method");
		Properties hibernateProperties=new Properties();
		
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.show_sql","true");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getDataSource());
		factory.addProperties(hibernateProperties);
		Class classes[]=new Class[]{Product.class,Category.class,User.class,Customer.class,Authorities.class,BillingAddress.class,ShippingAddress.class,CartItem.class,CustomerOrder.class};
		System.out.println("Session factory bean"+ factory);
		return factory.addAnnotatedClasses(classes).buildSessionFactory();
		
	}
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}

}
