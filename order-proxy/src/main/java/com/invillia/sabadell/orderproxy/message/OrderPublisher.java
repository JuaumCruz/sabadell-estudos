package com.invillia.sabadell.orderproxy.message;

import com.invillia.sabadell.orderproxy.contract.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class OrderPublisher {

    @Autowired
    private MessageChannel output;

    public void publishOrder(OrderResponse response) {
        output.send(MessageBuilder.withPayload(response).build());
    }
}
