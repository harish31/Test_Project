package com.scoperetail.order.persistence.entity;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.FieldPredicate.include;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

class OrderLineEnrichedTest {
  @Test
  public void shouldPassAllPojoTests() {
    // given
    final Class<?> classUnderTest = OrderLineEnriched.class;
    // then
    assertPojoMethodsFor(classUnderTest).testing(Method.GETTER, Method.SETTER).areWellImplemented();
//    assertPojoMethodsFor(classUnderTest, include("lineNbr"))
//        .testing(Method.EQUALS, Method.HASH_CODE)
//        .areWellImplemented();
  }
}
