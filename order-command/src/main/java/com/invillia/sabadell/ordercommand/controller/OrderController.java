package com.invillia.sabadell.ordercommand.controller;

import com.invillia.sabadell.ordercommand.contract.OrderRequest;
import com.invillia.sabadell.ordercommand.mapper.OrderMapper;
import com.invillia.sabadell.ordercommand.model.Order;
import com.invillia.sabadell.ordercommand.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private OrderMapper mapper;

    @PostMapping("/order")
    public Order createOrder(@RequestBody OrderRequest request) {
        return service.createOrder(mapper.toOrder(request));
    }
}
