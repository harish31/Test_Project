package com.scoperetail.order.persistence.entity;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.jupiter.api.Test;

import pl.pojo.tester.api.assertion.Method;

class EnrichSequenceTest {
  @Test
  public void shouldPassAllPojoTests() {
    // given
    final Class<?> classUnderTest = EnrichSequence.class;
    // then
    assertPojoMethodsFor(classUnderTest)
        .testing(Method.GETTER, Method.SETTER, Method.TO_STRING)
        .testing(Method.CONSTRUCTOR)
        .areWellImplemented();
//    assertPojoMethodsFor(classUnderTest, include("enrichSequencePK"))
//        .testing(Method.EQUALS, Method.HASH_CODE)
//        .areWellImplemented();
  }
}
