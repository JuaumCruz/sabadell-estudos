package com.invillia.sabadell.orderprocessor.contract;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    private Long idOrder;
    private Long idUser;
    private BigDecimal value;
    private OrderStatus status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
