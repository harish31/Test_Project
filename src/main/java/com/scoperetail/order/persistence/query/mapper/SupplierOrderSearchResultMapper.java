package com.scoperetail.order.persistence.query.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface SupplierOrderSearchResultMapper {

    Integer getOrderId();

    String getCogLabel();

    String getCustomerId();
    
    Long getSupplierId();

    LocalDateTime getCreatedTs();
    
    LocalDate getScheduledProcessDate();

    LocalDate getScheduledDeliveryDate();
    
    Long getTotalQuantity();
}
