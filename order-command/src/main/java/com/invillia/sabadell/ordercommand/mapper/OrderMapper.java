package com.invillia.sabadell.ordercommand.mapper;

import com.invillia.sabadell.ordercommand.contract.OrderRequest;
import com.invillia.sabadell.ordercommand.contract.OrderStatus;
import com.invillia.sabadell.ordercommand.model.Order;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {OrderStatus.class})
public interface OrderMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "idUser", source = "idUser")
    @Mapping(target = "value", source = "value")
    @Mapping(target = "status", expression = "java( OrderStatus.CREATED )")
    Order toOrder(OrderRequest request);

}
