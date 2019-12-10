package com.scoperetail.order.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scoperetail.order.persistence.entity.OrderLineSubstitution;

@Repository
public interface OrderLineSubstitutionRepository
    extends JpaRepository<OrderLineSubstitution, Integer> {
  @Query(
      value =
          "select ols from OrderLineSubstitution ols where ols.supplierOrder.orderId = :orderId and ols.orderLine.lineNbr = :lineNbr")
  List<OrderLineSubstitution> findByOrderIdAndLineNbr(
      @Param("orderId") Integer orderId, @Param("lineNbr") Integer lineNbr);
}
