package com.scoperetail.order.persistence.query.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderedLineDetailsDto {
  Integer orderId;

  Integer orderedItemQty;

  Long productId;
  
  String productDesc;
}
