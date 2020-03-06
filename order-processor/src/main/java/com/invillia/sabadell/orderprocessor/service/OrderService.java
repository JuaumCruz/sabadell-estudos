package com.invillia.sabadell.orderprocessor.service;

import com.invillia.sabadell.orderprocessor.aspect.ExecutionTimeTracker;
import com.invillia.sabadell.orderprocessor.client.UserQueryClient;
import com.invillia.sabadell.orderprocessor.contract.Order;
import com.invillia.sabadell.orderprocessor.contract.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.cloud.stream.messaging.Sink.INPUT;
import static org.springframework.cloud.stream.messaging.Source.OUTPUT;

@Service
@EnableBinding(Processor.class)
public class OrderService {

    @Autowired
    private UserQueryClient queryClient;

    @StreamListener(INPUT)
    @SendTo(OUTPUT)
    @ExecutionTimeTracker
    public Order processOrder(Order order) {
        order.setStatus(OrderStatus.FINISHED);

        var user = queryClient.get(order.getIdUser());

        if (Objects.isNull(user)) {
            order.setStatus(OrderStatus.INVALID);
            return order;
        }

        if (user.getCreditLimit().compareTo(order.getValue()) < 0) {
            order.setStatus(OrderStatus.CANCELED);
        }

        return order;
    }
}
