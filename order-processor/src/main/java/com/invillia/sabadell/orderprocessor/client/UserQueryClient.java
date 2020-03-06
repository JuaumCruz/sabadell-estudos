package com.invillia.sabadell.orderprocessor.client;

import com.invillia.sabadell.orderprocessor.aspect.ExecutionTimeTracker;
import com.invillia.sabadell.orderprocessor.contract.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-query", fallback = UserQueryClientFallback.class)
public interface UserQueryClient {

    @GetMapping("/user/{id}")
    @ExecutionTimeTracker
    User get(@PathVariable Long id);

}
