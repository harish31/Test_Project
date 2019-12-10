package com.scoperetail.order.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scoperetail.order.persistence.entity.OrderLineReplacement;

public interface OrderLineReplacementRepository
    extends JpaRepository<OrderLineReplacement, Integer> {}
