package com.scoperetail.order.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scoperetail.order.persistence.entity.SeaFoodConfig;

@Repository
public interface SeaFoodConfigRepository extends JpaRepository<SeaFoodConfig, Integer> {

  Optional<SeaFoodConfig> findBySupplierId(Long supplierId);

  List<SeaFoodConfig> findBySupplierIdIn(List<Long> supplierIds);
}
