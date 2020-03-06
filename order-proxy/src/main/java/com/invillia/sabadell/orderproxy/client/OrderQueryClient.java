package com.invillia.sabadell.orderproxy.client;

import com.invillia.sabadell.orderproxy.contract.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "order-query")
public interface OrderQueryClient {

    @GetMapping("/order")
    List<OrderResponse> getAll();

    @GetMapping("/order/{id}")
    OrderResponse get(@PathVariable Long id);

}
