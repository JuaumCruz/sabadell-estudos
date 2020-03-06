package com.invillia.sabadell.ordercommand.service;

import com.invillia.sabadell.ordercommand.exception.OrderNotFoundException;
import com.invillia.sabadell.ordercommand.message.OrderPublisher;
import com.invillia.sabadell.ordercommand.model.Order;
import com.invillia.sabadell.ordercommand.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import static org.springframework.cloud.stream.messaging.Sink.INPUT;
import static org.springframework.cloud.stream.messaging.Source.OUTPUT;

@Service
@EnableBinding(Processor.class)
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderPublisher publisher;

    public Order createOrder(Order request) {
        var response = repository.save(request);
        publisher.publishOrder(response);

        return response;
    }

    @StreamListener(INPUT)
    @SendTo(OUTPUT)
    public Order updateOrder(Order request) {
        return repository.findById(request.getIdOrder())
            .map(order -> {
                order.setStatus(request.getStatus());
                return repository.save(order);
            }).orElseThrow(() -> new OrderNotFoundException(request.getIdOrder()));
    }
}
