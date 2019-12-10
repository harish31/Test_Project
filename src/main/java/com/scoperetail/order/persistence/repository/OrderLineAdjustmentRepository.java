package com.scoperetail.order.persistence.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scoperetail.order.persistence.entity.OrderLine;
import com.scoperetail.order.persistence.entity.OrderLineAdjustment;

@Repository
public interface OrderLineAdjustmentRepository extends JpaRepository<OrderLineAdjustment, Integer> {

  Set<OrderLineAdjustment> findByOrderLine(OrderLine orderLine);
}
