package com.invillia.sabadell.orderprocessor.client;

import com.invillia.sabadell.orderprocessor.contract.User;
import org.springframework.stereotype.Component;

@Component
public class UserQueryClientFallback implements UserQueryClient {

    @Override
    public User get(Long id) {
        return null;
    }
}
