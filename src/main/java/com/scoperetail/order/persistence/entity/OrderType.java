package com.scoperetail.order.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType implements StaticData {
  REGULAR(101, "Regular"),
  RUSH(102, "Rush"),
  FIRM(103, "Firm"),
  STANDING(104, "Standing"),
  TRANSFER(105, "Transfer"),
  SYSTEM(106, "System");

  private int code;
  private String label;

  public static OrderType getOrderType(int code) {
    for (OrderType type : OrderType.values()) {
      if (type.getCode() == code) {
        return type;
      }
    }
    throw new IllegalArgumentException();
  }

  public static OrderType getOrderType(String label) {
    for (OrderType type : OrderType.values()) {
      if (type.getLabel().equalsIgnoreCase(label)) {
        return type;
      }
    }
    throw new IllegalArgumentException();
  }
}
