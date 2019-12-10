package com.scoperetail.order.persistence.custom.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.scoperetail.commons.orderLine.search.dto.request.OrderDetailsFinderRequest;
import com.scoperetail.order.persistence.custom.SubAlsoOrderedQtyFinder;
import com.scoperetail.order.persistence.entity.OrderLine;
import com.scoperetail.order.persistence.entity.OrderLineEnriched;
import com.scoperetail.order.persistence.entity.SupplierOrder;
import com.scoperetail.order.persistence.query.mapper.OrderedLineDetailsDto;

public class SubAlsoOrderedQtyFinderImpl implements SubAlsoOrderedQtyFinder {

  @PersistenceContext EntityManager entityManager;

  @Override
  public List<OrderedLineDetailsDto> getOriginalOrderedQty(
      final List<OrderDetailsFinderRequest> orderDetailsFinderList) {

    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<OrderedLineDetailsDto> query = cb.createQuery(OrderedLineDetailsDto.class);
    Root<OrderLine> orderLineRoot = query.from(OrderLine.class);
    final Join<SupplierOrder, Integer> supplierOrder = orderLineRoot.join("supplierOrder");
    final Join<OrderLineEnriched, Integer> orderLineEnriched =
        orderLineRoot.join("orderLineEnriched");

    Path<String> orderIdPath = supplierOrder.get("orderId");
    Path<String> prodIdPath = orderLineRoot.get("origProductId");

    List<Predicate> predicates = new ArrayList<>();

    orderDetailsFinderList
        .stream()
        .forEach(
            record -> {
              Predicate orderIdPredicate = cb.equal(orderIdPath, record.getOrderId());
              Predicate prodIdPredicate = cb.equal(prodIdPath, record.getOriginalProductId());
              Predicate orderIdAndProdId = cb.and(orderIdPredicate, prodIdPredicate);
              predicates.add(orderIdAndProdId);
            });

    query
        .multiselect(
            supplierOrder.get("orderId"),
            orderLineRoot.get("orderedItemQty"),
            orderLineRoot.get("productId"),
            orderLineEnriched.get("productDesc"))
        .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

    return entityManager.createQuery(query).getResultList();
  }
}
