package com.invillia.sabadell.ordercommand.message;

import com.invillia.sabadell.ordercommand.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(OrderSource.class)
public class OrderPublisher {

    @Autowired
    private OrderSource order;

    public void publishOrder(Order response) {
        order.outputMerge().send(MessageBuilder.withPayload(response).build());
        order.outputProcess().send(MessageBuilder.withPayload(response).build());
    }
}
