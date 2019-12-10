package com.scoperetail.order.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scoperetail.order.persistence.entity.SupplierOrder;
import com.scoperetail.order.persistence.entity.SupplierOrderEnriched;

public interface SupplierOrderEnrichedRepository
    extends JpaRepository<SupplierOrderEnriched, Integer> {}
