package com.scoperetail.order.persistence.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.jupiter.api.Test;

import com.scoperetail.order.persistence.entity.EnrichStatus;
import com.scoperetail.order.persistence.entity.OrderSchedStatus;
import com.scoperetail.order.persistence.entity.OrderType;

import pl.pojo.tester.api.assertion.Method;

public class EnumUtilsTest {

  @Test
  void findEnumByCode() {
    OrderType type = EnumUtils.findEnumType(OrderType.class, OrderType.RUSH.getCode());
    EnrichStatus enrichStatus =
        EnumUtils.findEnumType(EnrichStatus.class, EnrichStatus.NEW.getCode());
    OrderSchedStatus orderSchedStatus =
        EnumUtils.findEnumType(OrderSchedStatus.class, OrderSchedStatus.SCHEDULED.getCode());

    assertEquals(type, OrderType.RUSH);
    assertEquals(enrichStatus, EnrichStatus.NEW);
    assertEquals(orderSchedStatus, OrderSchedStatus.SCHEDULED);
  }

  @Test
  void findEnumByLabel() {
    OrderType type = EnumUtils.findEnumType(OrderType.class, OrderType.RUSH.getLabel());
    EnrichStatus enrichStatus =
            EnumUtils.findEnumType(EnrichStatus.class, EnrichStatus.NEW.getLabel());
        OrderSchedStatus orderSchedStatus =
            EnumUtils.findEnumType(OrderSchedStatus.class, OrderSchedStatus.SCHEDULED.getLabel());

    assertEquals(type, OrderType.RUSH);
    assertEquals(enrichStatus, EnrichStatus.NEW);
    assertEquals(orderSchedStatus, OrderSchedStatus.SCHEDULED);
  }

  @Test
  public void shouldPassAllPojoTests() {
    // given
    final Class<?> classUnderTest = EnumUtils.class;

    assertPojoMethodsFor(classUnderTest).testing(Method.CONSTRUCTOR).areWellImplemented();
  }
}
