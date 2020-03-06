package com.invillia.sabadell.orderproxy.contract;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class OrderRequest {
    private Long idUser;
    private BigDecimal value;
}
