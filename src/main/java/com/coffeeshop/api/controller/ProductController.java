package com.coffeeshop.api.controller;

import com.coffeeshop.api.domain.Order;
import com.coffeeshop.api.domain.Person;
import com.coffeeshop.api.domain.Product;
import com.coffeeshop.api.domain.ProductType;
import com.coffeeshop.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Crawlers on 5/23/2017.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product add(@RequestBody Product product) {
        System.out.println("Post product:"+ product);
        product = productService.save(product);
        System.out.println("Posted product:"+ product);
        return product;
    }

    @GetMapping("/search")
    public List<Product> getBySearch(@RequestParam("criteria") String search) {
        return productService.findByTextSearch(search);
    }

    @GetMapping("/price")
    public List<Product> getByPrice(@RequestParam("min") Double min, @RequestParam("max") Double max) {
        return productService.findByPrice(min,max);
    }

    @GetMapping("/type")
    public List<Product> getByType(@RequestParam("productType") ProductType productType) {
        return productService.findByProductType(productType);
    }

    @GetMapping
    public List<Product> getAll() {
        System.out.println("Get All called");
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

    /*@PutMapping(value="/product/{id}")
    public Person update(@PathVariable("id") int id, @RequestBody Person product) {
        return productService.update(id, product);
    }*/

    @DeleteMapping(value="/{id}")
    public void delete(@RequestBody Product product) {
        productService.delete(product);
    }
}
