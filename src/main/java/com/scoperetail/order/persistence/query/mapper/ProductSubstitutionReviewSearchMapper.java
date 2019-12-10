package com.scoperetail.order.persistence.query.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ProductSubstitutionReviewSearchMapper {
  Integer getCurrentItemQty();

  Integer getLineNbr();

  Long getCustomerId();

  String getDivisionId();

  Integer getOrderId();

  LocalDate getScheduledDeliveryDate();

  LocalDate getScheduledProcessDate();

  Long getProductId();

  LocalDateTime getCreatedOn();

  Integer getSysAdjustedItemQty();

  Integer getUserAdjustedItemQty();

  String getProductDesc();

  Long getSupplierId();

  Integer getOrderTypeId();

  String getState();

  Integer getCustTypeId();

  String getAllowedCustomerTypeIds();

  Integer getOrderedItemQty();
}
