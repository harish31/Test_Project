package com.scoperetail.order.persistence.query.mapper;

public interface RejectedOrderLineSearchMapper {

  Long getProductId();

  String getProductDesc();

  Integer getOrderId();

  Long getCustomerId();

  Long getSupplierId();

  Integer getRejectReasonCode();
}
