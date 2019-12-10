package com.scoperetail.order.persistence.repository;

import static com.scoperetail.order.persistence.utils.SupplierOrderConstants.SUPPLIER_ORDER_SEARCH_COUNT;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scoperetail.commons.manage.order.dto.request.SupplierOrderSearchRequest;
import com.scoperetail.commons.orderLine.search.dto.request.OrderLineSearchRequest;
import com.scoperetail.order.persistence.entity.SupplierOrder;
import com.scoperetail.order.persistence.query.mapper.AdjustedOrderLineSearchMapper;
import com.scoperetail.order.persistence.query.mapper.SubstitutedOrderLineSearchMapper;
import com.scoperetail.order.persistence.query.mapper.SupplierOrderSearchResultMapper;

@Repository
public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Integer> {

  @Query(name = "manage.order.search.orderid")
  Optional<List<Integer>> getSupplierOrderIds(
      @Param("productId") Long productId, @Param("supplierProductId") String supplierProductId);

  @Query(name = "manage.order.search.in")
  Page<SupplierOrder> getSupplierOrders(
      @Param("orderIds") List<Integer> orderIds,
      @Param("searchOrderRequest") SupplierOrderSearchRequest supplierOrderSearchRequest,
      Pageable pageable);

  @Query(
      name = "manage.order.search",
      countQuery =
          "SELECT COUNT(so) FROM SupplierOrder so INNER JOIN so.supplierOrderEnriched soe INNER JOIN so.orderCustomer oc WHERE (:#{#searchOrderRequest.orderId} is null or so.orderId=:#{#searchOrderRequest.orderId}) AND (COALESCE(:#{#searchOrderRequest.divisionId},null) IS NULL or so.suppDivisionId IN (:#{#searchOrderRequest.divisionId})) AND (:#{#searchOrderRequest.supplierId} is null or so.supplierId=:#{#searchOrderRequest.supplierId} ) AND ((:#{#searchOrderRequest.deliveryDateFrom} is null or soe.scheduledDeliveryDate>=:#{#searchOrderRequest.deliveryDateFrom}) AND (:#{#searchOrderRequest.deliveryDateTo} is null or soe.scheduledDeliveryDate<=:#{#searchOrderRequest.deliveryDateTo})) AND ((:#{#searchOrderRequest.processingDateFrom} is null or soe.scheduledProcessDate>=:#{#searchOrderRequest.processingDateFrom}) AND (:#{#searchOrderRequest.processingDateTo} is null or soe.scheduledProcessDate<=:#{#searchOrderRequest.processingDateTo})) AND ((:#{#searchOrderRequest.createdDateFrom} is null or soe.createTs>=:#{#searchOrderRequest.createdDateFrom}) AND (:#{#searchOrderRequest.createdDateTo} is null or soe.createTs<=:#{#searchOrderRequest.createdDateTo})) AND (:#{#searchOrderRequest.orderStatusId} is null or so.orderStatusId=:#{#searchOrderRequest.orderStatusId}) AND (:#{#searchOrderRequest.customerId} is null or oc.customerId=:#{#searchOrderRequest.customerId}) AND (:#{#searchOrderRequest.customerGroupId} is null or oc.cogId=:#{#searchOrderRequest.customerGroupId}) AND (:#{#searchOrderRequest.orderTypeId} is null or so.orderTypeId=:#{#searchOrderRequest.orderTypeId})")
  Page<SupplierOrder> getSupplierOrders(
      @Param("searchOrderRequest") SupplierOrderSearchRequest supplierOrderSearchRequest,
      Pageable pageable);

  Optional<List<SupplierOrder>> findByOrderIdInAndOrderStatusIdNotIn(
      List<Integer> orderIds, List<Integer> orderStatusIds);

  Optional<SupplierOrder> findByOrderIdAndOrderLines_LineNbrInAndOrderStatusIdNotIn(
      Integer orderId, List<Integer> lineNbr, List<Integer> orderStatusId);

  Optional<SupplierOrder> findByOrderIdAndOrderStatusIdNotIn(
      Integer orderId, List<Integer> orderStatusIds);

  @Modifying
  @Query(name = "update.orders.isLockedForEdit")
  int setIsLockedForEdit(
      @Param("orderIds") List<Integer> orderIds, @Param("isLocked") Character isLocked);

  // New search quries (rsc and total quantity)
  @Query(name = "manage.search.v2", countQuery = SUPPLIER_ORDER_SEARCH_COUNT)
  Page<SupplierOrder> getSupplierOrdersV2(
      @Param("searchOrderRequest") SupplierOrderSearchRequest supplierOrderSearchRequest,
      Pageable pageable);

  @Query(name = "manage.search.calculated.quantity")
  Page<SupplierOrderSearchResultMapper> getSupplierOrderCalQuantity(
      @Param("searchOrderRequest") SupplierOrderSearchRequest supplierOrderSearchRequest,
      @Param("orderLineStatusIds") List<Integer> orderLineStatusIds,
      Pageable pageable);

  @Query(
      "SELECT so FROM SupplierOrder so INNER JOIN FETCH so.orderCustomer INNER JOIN FETCH so.supplierOrderEnriched WHERE so.orderId in :orderIds")
  List<SupplierOrder> getByOrderIds(@Param("orderIds") Set<Integer> orderIds);

  @Query(name = "locked.supplier.orders")
  List<SupplierOrder> getLockedSupplierOrders(
      @Param("lineNbrs") List<Integer> lineNbrs,
      @Param("isLockedForEdit") Character isLockedForEdit,
      @Param("orderStatusIds") List<Integer> orderStatusIds);

  @EntityGraph(attributePaths = {"orderLines.orderLineAdjustments"})
  @Query(name = "auto.allocation.fetch.order")
  Optional<SupplierOrder> findAutoAllocationSupplierOrder(@Param("orderId") Integer orderId);

  @EntityGraph(
      attributePaths = {
        "orderTogs",
        "orderLines.orderLineAdjustments",
        "orderLines.orderLineSubstitutions"
      })
  @Query(name = "sequencer.fetch.order")
  Optional<SupplierOrder> findSequencerSupplierOrder(@Param("orderId") Integer orderId);

  @EntityGraph(attributePaths = {"orderLines.orderLineSubstitutions"})
  @Query(name = "order.visibilty.fetch.order")
  Optional<SupplierOrder> findOrderVisibilitySupplierOrder(@Param("orderId") Integer orderId);

  @Query(name = "substituted.order.lines.search")
  Page<SubstitutedOrderLineSearchMapper> searchSubstitutedLines(
      @Param("request") OrderLineSearchRequest request, Pageable pageable);

  @Query(name = "adjusted.order.lines.search")
  Page<AdjustedOrderLineSearchMapper> searchAdjustedLines(
      @Param("request") OrderLineSearchRequest request, Pageable pageable);
}
