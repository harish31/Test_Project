package com.scoperetail.order.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scoperetail.order.persistence.entity.AutoAllocationConfig;

@Repository
public interface AutoAllocationConfigRepository
    extends JpaRepository<AutoAllocationConfig, Integer> {

  Optional<AutoAllocationConfig> findBySupplierId(Long supplierId);

  Optional<List<AutoAllocationConfig>> findBySupplierIdIn(List<Long> supplierIds);
}
