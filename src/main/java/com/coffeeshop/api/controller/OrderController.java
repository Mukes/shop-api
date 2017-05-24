package com.coffeeshop.api.controller;

import com.coffeeshop.api.domain.Order;
import com.coffeeshop.api.domain.Person;
import com.coffeeshop.api.domain.Product;
import com.coffeeshop.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Crawlers on 5/23/2017.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order add(@RequestBody Order order) {
        System.out.println("Post order:"+ order);
        order = orderService.save(order);
        System.out.println("Posted order:"+ order);
        return order;
    }

    @GetMapping("/product")
    public List<Order> getByProduct(@RequestParam("id") Integer id) {
        return orderService.findByProduct(new Product(id));
    }

    @GetMapping("/person")
    public List<Order> getByPerson(@RequestParam("id") Long id) {
        return orderService.findByPerson(new Person(id));
    }

    @GetMapping("/date")
    public List<Order> getByDate(@RequestParam("start") Date start, @RequestParam("end") Date end) {
        return orderService.findByDate(start, end);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Integer id) {
        return orderService.findById(id);
    }

    /*@PutMapping(value="/order/{id}")
    public Person update(@PathVariable("id") int id, @RequestBody Person order) {
        return orderService.update(id, order);
    }*/

    @DeleteMapping(value="/{id}")
    public void delete(@RequestBody Order order) {
        orderService.delete(order);
    }
}
