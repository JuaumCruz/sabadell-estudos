package com.invillia.sabadell.ordercommand.service;

import com.invillia.sabadell.ordercommand.exception.OrderNotFoundException;
import com.invillia.sabadell.ordercommand.message.OrderPublisher;
import com.invillia.sabadell.ordercommand.message.OrderSource;
import com.invillia.sabadell.ordercommand.model.Order;
import com.invillia.sabadell.ordercommand.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import static com.invillia.sabadell.ordercommand.message.OrderSource.OrderQueue.INPUT_UPDATE;
import static com.invillia.sabadell.ordercommand.message.OrderSource.OrderQueue.OUTPUT_MERGE;

@Service
@EnableBinding(OrderSource.class)
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

    @StreamListener(INPUT_UPDATE)
    @SendTo(OUTPUT_MERGE)
    public Order updateOrder(Order request) {
        return repository.findById(request.getIdOrder())
            .map(order -> {
                order.setStatus(request.getStatus());
                return repository.save(order);
            }).orElseThrow(() -> new OrderNotFoundException(request.getIdOrder()));
    }
}
