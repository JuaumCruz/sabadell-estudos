package com.invillia.sabadell.orderquery.repository;

import com.invillia.sabadell.orderquery.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }
