package com.invillia.sabadell.orderquery.controller;

import com.invillia.sabadell.orderquery.service.OrderService;
import com.invillia.sabadell.orderquery.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/order")
    public List<Order> getAll() {
        return service.getAll();
    }

    @GetMapping("/order/{id}")
    public Order get(@PathVariable Long id) {
        return service.get(id);
    }
}
