package com.scoperetail.order.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scoperetail.order.persistence.entity.ShippingPalletCubeConfig;

@Repository
public interface ShippingPalletCubeConfigRepository
    extends JpaRepository<ShippingPalletCubeConfig, Long> {

  Optional<ShippingPalletCubeConfig> findBySupplierId(Long supplierId);

  List<ShippingPalletCubeConfig> findBySupplierIdIn(List<Long> supplierIds);
}
