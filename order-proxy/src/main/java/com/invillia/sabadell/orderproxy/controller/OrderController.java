package com.invillia.sabadell.orderproxy.controller;

import com.invillia.sabadell.orderproxy.contract.OrderRequest;
import com.invillia.sabadell.orderproxy.contract.OrderResponse;
import com.invillia.sabadell.orderproxy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping(path = "/order")
    public OrderResponse create(@RequestBody OrderRequest request) {
        return service.create(request);
    }

    @GetMapping("/order")
    public List<OrderResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/order/{id}")
    public OrderResponse get(@PathVariable Long id) {
        return service.get(id);
    }
}
