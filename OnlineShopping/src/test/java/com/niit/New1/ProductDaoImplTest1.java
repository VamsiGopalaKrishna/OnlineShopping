package com.niit.New1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Model.Product;
import com.niit.OnlineShopping.DBconfig;

public class ProductDaoImplTest1 {
	ApplicationContext context=new AnnotationConfigApplicationContext(DBconfig.class,ProductDaoImpl.class);
	ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
/*
	@Test
	public void testSaveProduct() {
		
	}

	@Test
	public void testGetProduct() {
		 
	}
	
	@Test
	public void testGetAllProducts(){
		List<Product> products=productDao.getAllProducts();
		assertTrue(products.size()>0);
		assertFalse(products.isEmpty());
	}

	@Test
	public void testUpdateProduct() {
	Product product=productDao.getProduct(38);
	product.setPrice(150);
	product.setQuantity(30);
	productDao.updateProduct(product);
	assertTrue(product.getPrice()==150);
	assertTrue(product.getQuantity()==30);
	}
*/
}
