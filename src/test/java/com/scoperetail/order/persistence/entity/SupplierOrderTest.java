package com.scoperetail.order.persistence.entity;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.FieldPredicate.include;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

class SupplierOrderTest {
  //@Test
  public void shouldPassAllPojoTests() {
    // given
    final Class<?> classUnderTest = SupplierOrder.class;
    // then 
    assertPojoMethodsFor(classUnderTest)
        .testing(Method.GETTER, Method.SETTER, Method.TO_STRING)
        .testing(Method.CONSTRUCTOR)
        .areWellImplemented();
    assertPojoMethodsFor(classUnderTest, include("orderId"))
        .testing(Method.EQUALS, Method.HASH_CODE)
        .areWellImplemented();
  }
}
