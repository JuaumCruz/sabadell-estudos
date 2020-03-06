package com.invillia.sabadell.orderquery.contract;

import lombok.Getter;

@Getter
public enum OrderStatus {

    CREATED(1L, "Created"),
    FINISHED(2L, "Finished"),
    CANCELED(3L, "Canceled"),
    INVALID(4L, "Invalid");

    Long value;
    String description;

    OrderStatus(Long value, String description) {
        this.value = value;
        this.description = description;
    }
}
