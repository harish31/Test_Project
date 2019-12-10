package com.scoperetail.order.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scoperetail.order.persistence.entity.OrderCustomer;

public interface OrderCustomerRepository extends JpaRepository<OrderCustomer, Integer> {}
