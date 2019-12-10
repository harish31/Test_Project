package com.scoperetail.order.persistence.entity;

import static pl.pojo.tester.api.FieldPredicate.include;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.jupiter.api.Test;

import pl.pojo.tester.api.assertion.Method;

class EnrichTrackerTest {
  @Test
  public void shouldPassAllPojoTests() {
    // given
    final Class<?> classUnderTest = EnrichTracker.class;
    // then
    assertPojoMethodsFor(classUnderTest)
        .testing(Method.GETTER, Method.SETTER, Method.TO_STRING)
        .testing(Method.CONSTRUCTOR)
        .areWellImplemented();
    assertPojoMethodsFor(classUnderTest, include("enrichTrackerId"))
        .testing(Method.EQUALS, Method.HASH_CODE)
        .areWellImplemented();
  }
}
