package com.scoperetail.order.persistence.utils;

public class SupplierOrderConstants {

    public static final String SUPPLIER_ORDER_SEARCH_COUNT = "SELECT count(so) " +
            " FROM SupplierOrder so " +
            "  INNER JOIN  so.supplierOrderEnriched soe " +
            "  INNER JOIN  so.orderCustomer oc " +
            " WHERE (:#{#searchOrderRequest.orderId} is null or so.orderId=:#{#searchOrderRequest.orderId}) " +
            " AND (COALESCE(:#{#searchOrderRequest.divisionId},null) IS NULL or so.suppDivisionId IN (:#{#searchOrderRequest.divisionId})) " +
            " AND (:#{#searchOrderRequest.supplierId} is null or so.supplierId=:#{#searchOrderRequest.supplierId} ) " +
            " AND ((:#{#searchOrderRequest.deliveryDateFrom} is null or soe.scheduledDeliveryDate>=:#{#searchOrderRequest.deliveryDateFrom}) " +
            " AND (:#{#searchOrderRequest.deliveryDateTo} is null or soe.scheduledDeliveryDate<=:#{#searchOrderRequest.deliveryDateTo})) " +
            " AND ((:#{#searchOrderRequest.processingDateFrom} is null or soe.scheduledProcessDate>=:#{#searchOrderRequest.processingDateFrom}) " +
            " AND (:#{#searchOrderRequest.processingDateTo} is null or soe.scheduledProcessDate<=:#{#searchOrderRequest.processingDateTo})) " +
            " AND ((:#{#searchOrderRequest.createdDateFrom} is null or soe.createTs>=:#{#searchOrderRequest.createdDateFrom}) " +
            " AND (:#{#searchOrderRequest.createdDateTo} is null or soe.createTs<=:#{#searchOrderRequest.createdDateTo})) " +
            " AND (:#{#searchOrderRequest.orderStatusId} is null or so.orderStatusId=:#{#searchOrderRequest.orderStatusId}) " +
            " AND (:#{#searchOrderRequest.customerId} is null or oc.customerId=:#{#searchOrderRequest.customerId}) " +
            " AND (:#{#searchOrderRequest.customerGroupId} is null or oc.cogId=:#{#searchOrderRequest.customerGroupId}) " +
            " AND (:#{#searchOrderRequest.orderTypeId} is null " +
            	 	 " OR (:#{#searchOrderRequest.futureOrder} = 'N' AND so.futureOrder = 'N' AND so.orderTypeId=:#{#searchOrderRequest.orderTypeId}) "+
            	 	 " OR (so.futureOrder = 'Y' AND so.orderTypeId=:#{#searchOrderRequest.orderTypeId})) "+
            	 " AND (:#{#searchOrderRequest.userId} is null or so.createdBy=:#{#searchOrderRequest.userId})" +
            " AND (:#{#searchOrderRequest.customerDivisionId} is null or oc.divisionId=:#{#searchOrderRequest.customerDivisionId}) " +
            " AND (:#{#searchOrderRequest.eq} is null or soe.totalItemQty = :#{#searchOrderRequest.totalQuantity.intValue()})" +
            " AND (:#{#searchOrderRequest.lt} is null or soe.totalItemQty < :#{#searchOrderRequest.totalQuantity.intValue()})" +
            " AND (:#{#searchOrderRequest.lte} is null or soe.totalItemQty <= :#{#searchOrderRequest.totalQuantity.intValue()})" +
            " AND (:#{#searchOrderRequest.gt} is null or soe.totalItemQty > :#{#searchOrderRequest.totalQuantity.intValue()})" +
            " AND (:#{#searchOrderRequest.gte} is null or soe.totalItemQty >= :#{#searchOrderRequest.totalQuantity.intValue()}) ";


    private SupplierOrderConstants() {}
}
