package com.invillia.sabadell.orderproxy.client;

import com.invillia.sabadell.orderproxy.contract.OrderRequest;
import com.invillia.sabadell.orderproxy.contract.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "order-command")
public interface OrderCommandClient {

    @PostMapping("/order")
    public OrderResponse create(@RequestBody OrderRequest request);

}
