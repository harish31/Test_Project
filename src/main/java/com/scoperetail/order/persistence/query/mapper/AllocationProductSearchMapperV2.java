package com.scoperetail.order.persistence.query.mapper;

public interface AllocationProductSearchMapperV2 {

  Long getProductId();

  Integer getTotalLines();

  Integer getOrderedQty();

  String getProductDesc();
  
  Integer getBoh();
  
  Integer getRawAvailQty();
  
  Integer getFutureRecvQty();
  
  Integer getDiff();
  
  Integer getTotalOriginalQty();
}
