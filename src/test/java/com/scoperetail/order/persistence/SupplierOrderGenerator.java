package com.scoperetail.order.persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.scoperetail.commons.enums.EnrichmentStatus;
import com.scoperetail.commons.enums.OrderLineStatus;
import com.scoperetail.commons.enums.OrderStatus;
import com.scoperetail.order.persistence.entity.OrderLine;
import com.scoperetail.order.persistence.entity.OrderLineEnriched;
import com.scoperetail.order.persistence.entity.OrderSchedStatus;
import com.scoperetail.order.persistence.entity.OrderTog;
import com.scoperetail.order.persistence.entity.OrderType;
import com.scoperetail.order.persistence.entity.SupplierOrder;
import com.scoperetail.order.persistence.entity.UnitOfMeasure;

public enum SupplierOrderGenerator {
  INSTANCE;
  private final Random random = new Random();

  public SupplierOrder createSupplierOrder(
      final int numberOfOrderLines, final boolean createOrderLineEnriched) {
    final SupplierOrder supplierOrder =
        SupplierOrder.builder()
            .custOrderId(1)
            .batchId(1)
            .supplierId(Long.valueOf(1))
            .supplierTypeId(1)
            .supplierName("abc")
            .orderTypeId(OrderType.RUSH.getCode())
            .orderStatusId(OrderStatus.NEW.getCode())
            .orderSchedStatusId(OrderSchedStatus.SCHEDULED.getCode())
            .enrichmentStatus(EnrichmentStatus.NOT_STARTED.getLabel())
            .sysOrdReleaseTs(LocalDateTime.now())
            .veto('N')
            .build();
    // Generate orderlines
    final Set<OrderLine> orderLineList = new HashSet();
    for (int i = 1; i <= numberOfOrderLines; i++) {
      final Long productId = random.nextLong();
      final OrderLine orderLine =
          OrderLine.builder()
              .supplierOrder(supplierOrder)
              .orderLineStatusId(OrderLineStatus.ACTIVE.getCode())
              .productId(productId)
              .origProductId(productId)
              .orderedItemQty(25)
              .orderedItemWgt(BigDecimal.ONE)
              .orderedUom(UnitOfMeasure.EACH.getCode())
              .build();
      if (createOrderLineEnriched) {
        final OrderLineEnriched orderLineEnriched =
            OrderLineEnriched.builder().orderLine(orderLine).supplierOrder(supplierOrder).build();
        orderLine.setOrderLineEnriched(orderLineEnriched);
      }
      orderLineList.add(orderLine);
    }
    final Set<OrderTog> ordertogList = new HashSet<>();
    for (int i = 1; i <= numberOfOrderLines; i++) {

      final OrderTog orderTog =
          OrderTog.builder()
              .supplierOrder(supplierOrder)
              .downloadType("aaa")
              .clazz("aaa")
              .origin("aaa")
              .destination("aaa")
              .togLabel("aaa")
              .build();

      ordertogList.add(orderTog);
    }
    supplierOrder.setOrderLines(orderLineList);
    supplierOrder.setOrderTogs(ordertogList);
    return supplierOrder;
  }
}
