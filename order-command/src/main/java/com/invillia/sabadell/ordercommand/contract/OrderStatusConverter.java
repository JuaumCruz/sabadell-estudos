package com.invillia.sabadell.ordercommand.contract;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Long> {
    @Override
    public Long convertToDatabaseColumn(OrderStatus attribute) {
        return null == attribute ? null : attribute.getValue();
    }

    @Override
    public OrderStatus convertToEntityAttribute(Long value) {
        return null == value ? null :
            Stream.of(OrderStatus.values())
                .filter(s -> s.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
