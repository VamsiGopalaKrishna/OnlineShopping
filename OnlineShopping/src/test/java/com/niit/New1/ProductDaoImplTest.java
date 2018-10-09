package com.niit.New1;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Model.Product;
import com.niit.OnlineShopping.DBconfig;

import junit.framework.TestCase;

public class ProductDaoImplTest extends TestCase {
	ApplicationContext context=new AnnotationConfigApplicationContext(DBconfig.class,ProductDaoImpl.class);
ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
	@Test
	public void testSaveProduct() {
		/*Product product=new Product();
		
	product.setProductname("Bicycle2");
		product.setProductdesc("Details about bicycle2");
		product.setPrice(200);
		product.setQuantity(11);
		
		
		assertEquals("record saved",false,productDao.saveProduct(product));*/
		
	}

	@Test
	@Ignore
	public void testGetProduct() {
	/*Product product1=productDao.getProduct(36);
	assertNotNull(product1);
	
	double expectedPrice=400;
	double actualPrice=product1.getPrice();
	assertTrue(expectedPrice==actualPrice);
	*/}

}
