package com.invillia.sabadell.orderquery.service;

import com.invillia.sabadell.orderquery.exception.OrderNotFoundException;
import com.invillia.sabadell.orderquery.model.Order;
import com.invillia.sabadell.orderquery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.cloud.stream.messaging.Sink.INPUT;

@Service
@EnableBinding(Sink.class)
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order get(Long id) {
        return repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    @StreamListener(INPUT)
    public void merge(Order order) {
        repository.save(order);
    }
}
