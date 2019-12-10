package com.scoperetail.order.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scoperetail.commons.allocation.dto.request.AllocationReviewRequest;
import com.scoperetail.commons.allocation.dto.request.AllocationSearchRequest;
import com.scoperetail.commons.allocation.dto.request.AllocationSearchRequestV2;
import com.scoperetail.commons.allocation.dto.request.ProductCancelRequest;
import com.scoperetail.commons.allocation.dto.request.ProductSubstitutionReviewRequest;
import com.scoperetail.commons.orderLine.search.dto.request.OrderLineSearchRequest;
import com.scoperetail.order.persistence.custom.SubAlsoOrderedQtyFinder;
import com.scoperetail.order.persistence.entity.OrderLine;
import com.scoperetail.order.persistence.query.mapper.AllocationProductSearchMapper;
import com.scoperetail.order.persistence.query.mapper.AllocationProductSearchMapperV2;
import com.scoperetail.order.persistence.query.mapper.AllocationReviewSearchMapper;
import com.scoperetail.order.persistence.query.mapper.ProductSubstitutionReviewSearchMapper;
import com.scoperetail.order.persistence.query.mapper.RejectedOrderLineSearchMapper;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer>, SubAlsoOrderedQtyFinder {

  @Query(name = "allocation.search")
  Page<AllocationProductSearchMapper> findOrderLines(
      @Param("allocationSearchRequest") AllocationSearchRequest allocationSearchRequest,
      Pageable pageable,
      @Param("invalidOrderLineStatuses") List<Integer> invalidOrderLineStatuses,
      @Param("orderStatusIds") List<Integer> orderStatusIds,
      @Param("orderTypeIds") List<Integer> orderTypeIds,
      @Param("isLockedForEdit") Character isLockedForEdit);

  @Query(name = "order.allocation.brute.force.search")
  Page<AllocationProductSearchMapperV2> orderAllocationBruteForceSearch(
      @Param("allocationSearchRequest") AllocationSearchRequestV2 allocationSearchRequest,
      @Param("invalidOrderLineStatuses") List<Integer> invalidOrderLineStatuses,
      @Param("orderStatusIds") List<Integer> orderStatusIds,
      @Param("orderTypeIds") List<Integer> orderTypeIds,
      @Param("isLockedForEdit") Character isLockedForEdit, 
      Pageable pageable);

  @Query(name = "order.allocation.turbo.search")
  Page<AllocationProductSearchMapperV2> orderAllocationTurboSearch(
      @Param("allocationSearchRequest") AllocationSearchRequestV2 allocationSearchRequest,
      @Param("invalidOrderLineStatuses") List<Integer> invalidOrderLineStatuses,
      @Param("orderStatusIds") List<Integer> orderStatusIds,
      @Param("orderTypeIds") List<Integer> orderTypeIds,
      @Param("isLockedForEdit") Character isLockedForEdit, 
      Pageable pageable);
  
  @Query(name = "product.allocation.review")
  List<AllocationReviewSearchMapper> findOrderLines(
      @Param("allocationReviewRequest") AllocationReviewRequest allocationReviewRequest,
      @Param("invalidOrderLineStatuses") List<Integer> invalidOrderLineStatuses,
      @Param("orderStatusIds") List<Integer> orderStatusIds,
      @Param("orderTypeIds") List<Integer> orderTypeIds,
      @Param("isLockedForEdit") Character isLockedForEdit);

  @Query(name = "product.substitution.review")
  List<ProductSubstitutionReviewSearchMapper> findOrderLines(
      @Param("substitutionReviewRequest")
          ProductSubstitutionReviewRequest substitutionReviewRequest,
      @Param("invalidOrderLineStatuses") List<Integer> invalidOrderLineStatuses,
      @Param("orderStatusIds") List<Integer> orderStatusIds,
      @Param("orderTypeIds") List<Integer> orderTypeIds,
      @Param("isLockedForEdit") Character isLockedForEdit);

  @Query(name = "product.cancel.search.lines")
  List<OrderLine> findOrderLines(
      @Param("productCancelRequest") ProductCancelRequest productCancelRequest,
      @Param("invalidOrderLineStatuses") List<Integer> invalidOrderLineStatuses,
      @Param("orderStatusIds") List<Integer> orderStatusIds,
      @Param("orderTypeIds") List<Integer> orderTypeIds,
      @Param("isLockedForEdit") Character isLockedForEdit);

  @EntityGraph(attributePaths = {"orderLineAdjustments", "orderLineSubstitutions"})
  @Query(name = "product.substitution.review.submit")
  List<OrderLine> findOrderLines(@Param("lineNbrs") List<Integer> lineNbrs);

  @Query(name = "product.allocation.review.submit")
  List<OrderLine> findOrderLines(
      @Param("lineNbrs") List<Integer> lineNbrs,
      @Param("invalidOrderLineStatuses") List<Integer> invalidOrderLineStatuses);

  // All customers that have placed the order without considering order statuses
  @Query(name = "product.allocation.review.findCustomers")
  List<Long> findCustomersByOrderLines(
      @Param("allocationReviewRequest") AllocationReviewRequest allocationReviewRequest);

  @Query(name = "rejected.order.lines.search")
  Page<RejectedOrderLineSearchMapper> searchRejectedLines(
      @Param("request") OrderLineSearchRequest request,
      @Param("orderLineStatusIds") List<Integer> orderLineStatusIds,
      Pageable pageable);

}
