package com.scoperetail.order.persistence.entity;

import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.FieldPredicate.include;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

class SupplierOrderEnrichedTest {
  //  @Test
  public void shouldPassAllPojoTests() {
    // given
    final Class<?> classUnderTest = SupplierOrderEnriched.class;
    // then
    assertPojoMethodsFor(classUnderTest)
        .testing(Method.GETTER, Method.SETTER)
        .areWellImplemented(); // , Method.TO_STRING)
    //        .testing(Method.CONSTRUCTOR)
    //        .areWellImplemented();
    assertPojoMethodsFor(classUnderTest, include("orderId"))
        .testing(Method.EQUALS, Method.HASH_CODE)
        .areWellImplemented();
  }
}
