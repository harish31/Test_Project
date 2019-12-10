package com.scoperetail.order.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnrichStatus implements StaticData {
  NEW(401, "New");
  private int code;
  private String label;
}
