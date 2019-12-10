package com.scoperetail.order.persistence.query.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface AllocationReviewSearchMapper {

  Integer getCurrentItemQty();

  Integer getLineNbr();

  Long getCustomerId();

  String getDivisionId();

  Integer getOrderId();

  LocalDate getScheduledDeliveryDate();

  LocalDate getScheduledProcessDate();

  Integer getProductId();

  LocalDateTime getCreatedOn();

  Integer getSysAdjustedItemQty();

  Integer getUserAdjustedItemQty();

  Integer getOrderedItemQty();
  
  Integer getOrderTypeId();
}
