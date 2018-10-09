package com.niit.New1;

import java.util.List;

import com.niit.Model.Category;
import com.niit.Model.Product;

public interface ProductDao {
	Product saveProduct(Product product);
	Product getProduct(int id);
	
	void updateProduct(Product product);
	void deleteProduct(int id);
List<Product> getAllProducts();

List<Category> getAllCategories();
}
