package com.scoperetail.order.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scoperetail.order.persistence.entity.OrderTog;
import com.scoperetail.order.persistence.entity.SupplierOrder;

@Repository
public interface OrderTogRepository extends JpaRepository<OrderTog, Integer> {}
