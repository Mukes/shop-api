package com.coffeeshop.api.service;

import com.coffeeshop.api.domain.Product;
import com.coffeeshop.api.domain.ProductType;
import com.coffeeshop.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService   {
	
	@Autowired
	private ProductRepository productRepository;
		
	public Product save(Product product) {
		return productRepository.save(product);
	}

	public void delete(Product product) {
		productRepository.delete(product);
	}

	public Product getProduct(int productId) {
		return  productRepository.findOne(productId);
	}

	public List<Product> getAllProduct() {
		return  productRepository.findAll() ;
	}
	
	public List<Product> findByTextSearch(String criteria) {
		if (!criteria.contains("%")) {
			criteria = "%"+criteria+"%";
		}
		return productRepository.findByProductNameLikeOrDescriptionLikeAllIgnoreCase(criteria, criteria);
	}

	public List<Product> findByPrice(double minPrice, double maxPrice) {
		return  productRepository.findByPriceBetween(minPrice, maxPrice);
	}
	
	public List<Product> findByProductType(ProductType productType) {
		 return productRepository.findByProductType(productType);
	}
	
}
