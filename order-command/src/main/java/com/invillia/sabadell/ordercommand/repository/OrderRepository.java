package com.invillia.sabadell.ordercommand.repository;

import com.invillia.sabadell.ordercommand.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }
