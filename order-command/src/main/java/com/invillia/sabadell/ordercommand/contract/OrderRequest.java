package com.invillia.sabadell.ordercommand.contract;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class OrderRequest {
    private Long idUser;
    private BigDecimal value;
}
