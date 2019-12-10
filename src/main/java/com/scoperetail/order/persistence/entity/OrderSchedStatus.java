package com.scoperetail.order.persistence.entity;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderSchedStatus implements StaticData {
  SCHEDULED(501, "SCHEDULED");

  private int code;
  private String label;

  public static OrderSchedStatus getOrderSchedStatus(final int code) {
    return Arrays.stream(OrderSchedStatus.values())
        .filter(s -> s.getCode() == code)
        .findFirst()
        .get();
  }

  public static OrderSchedStatus getOrderSchedStatus(final String label) {
    return Arrays.stream(OrderSchedStatus.values())
        .filter(s -> s.getLabel().equals(label))
        .findFirst()
        .get();
  }
}
