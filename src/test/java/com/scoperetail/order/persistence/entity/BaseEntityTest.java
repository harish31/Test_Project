package com.scoperetail.order.persistence.entity;

import org.junit.jupiter.api.Test;

import pl.pojo.tester.api.FieldPredicate;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

class BaseEntityTest {
  @Test
  public void shouldPassAllPojoTests() {
    // given
    final Class<?> classUnderTest = BaseEntity.class;
    // then
    assertPojoMethodsFor(classUnderTest)
        .testing(Method.GETTER, Method.SETTER, Method.TO_STRING)
        .areWellImplemented();
  }
}
