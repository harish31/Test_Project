package com.scoperetail.order.persistence.query.mapper;

import java.time.LocalDateTime;

public interface AdjustedOrderLineSearchMapper {

  Integer getOrderId();

  Long getCustomerId();

  String getCustomerName();
  
  Long getProductId();
  
  String getProductDesc();

  Long getSupplierId();

  Integer getOrderedItemQty();
  
  Integer getAdjustmentItemQty();

  Short getAdjustmentReasonId();
  
  LocalDateTime getCreateTs();
}
