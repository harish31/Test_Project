package com.scoperetail.order.persistence.query.mapper;

public interface SubstitutedOrderLineSearchMapper {

  Integer getOrderId();

  Long getCustomerId();

  Long getSupplierId();

  Integer getSubsTypeId();

  Long getOriginalProductId();

  Long getCurrentProductId();

  Long getSubsProductId();

  Integer getOrderedItemQty();

  Integer getCurrentItemQty();

  Integer getSubsOrderedQty();

  String getProductDesc();

  String getSubProductDesc();
}
