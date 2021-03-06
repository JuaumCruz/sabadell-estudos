package com.invillia.sabadell.orderproxy.service;

import com.invillia.sabadell.orderproxy.client.OrderCommandClient;
import com.invillia.sabadell.orderproxy.client.OrderQueryClient;
import com.invillia.sabadell.orderproxy.contract.OrderRequest;
import com.invillia.sabadell.orderproxy.contract.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderCommandClient commandClient;

    @Autowired
    OrderQueryClient queryClient;

    public OrderResponse create(OrderRequest request) {
        return commandClient.create(request);
    }

    public OrderResponse get(Long id) {
        return queryClient.get(id);
    }

    public List<OrderResponse> getAll() {
        return queryClient.getAll();
    }

}
