package com.scoperetail.order.persistence.entity;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UnitOfMeasure {
  PALLET("PL"),
  EACH("EA"),
  INNER_PACK("IP"),
  CASE("CP");

  private String code;

  public static UnitOfMeasure getUnitOfMeasure(final String code) {
    return Arrays.stream(UnitOfMeasure.values())
        .filter(s -> s.getCode().equals(code))
        .findFirst()
        .get();
  }
}
