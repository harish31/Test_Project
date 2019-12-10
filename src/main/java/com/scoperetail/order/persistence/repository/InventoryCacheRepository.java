package com.scoperetail.order.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scoperetail.order.persistence.entity.InventoryCache;

public interface InventoryCacheRepository extends JpaRepository<InventoryCache, Integer> {

  @Query(name = "inventory.cache.search.in")
  List<InventoryCache> getInventoryCaches(
      @Param("supplierId") Long supplierId,
      @Param("productIds") List<Long> productIds,
      @Param("thresoldTime") LocalDateTime thresoldTime);

  List<InventoryCache> findByProductIdInAndSupplierId(List<Long> productdIds, Long supplierId);
}
