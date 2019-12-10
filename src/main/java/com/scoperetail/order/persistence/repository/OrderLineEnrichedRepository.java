package com.scoperetail.order.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scoperetail.order.persistence.entity.OrderLineEnriched;

public interface OrderLineEnrichedRepository extends JpaRepository<OrderLineEnriched, Integer> {}
