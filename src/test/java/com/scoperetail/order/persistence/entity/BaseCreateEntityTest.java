package com.scoperetail.order.persistence.entity;

import org.junit.jupiter.api.Test;

import pl.pojo.tester.api.FieldPredicate;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

class BaseCreateEntityTest {
  @Test
  public void shouldPassAllPojoTests() {
    // given
    final Class<?> classUnderTest = BaseCreateEntity.class;
    // then
    assertPojoMethodsFor(classUnderTest, FieldPredicate.exclude("createdBy"))
        .testing(Method.GETTER, Method.SETTER, Method.TO_STRING)
        .areWellImplemented();
  }
}
