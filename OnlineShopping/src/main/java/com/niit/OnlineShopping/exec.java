package com.niit.OnlineShopping;

import java.util.List;

import org.h2.engine.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Model.Product;
import com.niit.New1.ProductDao;
import com.niit.New1.ProductDaoImpl;

public class exec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context= new AnnotationConfigApplicationContext(DBconfig.class,ProductDaoImpl.class);
	ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
	
	List<Product> products=productDao.getAllProducts();
	for(Product p:products){
	System.out.println(p.getId()+ " " + p.getProductname()+ "  " + p.getProductdesc() + "  " + p.getPrice() + "  " + p.getQuantity() + "  ");
	}

}
}
