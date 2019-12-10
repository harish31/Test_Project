package com.scoperetail.order.persistence.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scoperetail.order.persistence.entity.Capability;
import com.scoperetail.order.persistence.entity.EnrichTracker;

public interface EnrichTrackerRepository extends JpaRepository<EnrichTracker, Integer> {

  static final String FIND_DELAYED_ORDERS_QUERY =
      "SELECT et FROM EnrichTracker et JOIN FETCH et.capability cp WHERE et.enrichStatusId IN :statusIds AND et.capabilityTimeOut <=:currentTime";

  @EntityGraph(attributePaths = {"capability"})
  List<EnrichTracker> findByOrderIdOrderByEnrichSequence(Integer orderId);

  @Query(FIND_DELAYED_ORDERS_QUERY)
  List<EnrichTracker> findDelayedOrders(
      @Param("statusIds") Collection<Integer> statusIds,
      @Param("currentTime") LocalDateTime currentTime);

  Optional<EnrichTracker> findByOrderIdAndCapability(Integer orderId, Capability capability);

  @Modifying
  @Query(name = "update.enrich.tracker.status")
  int updateStatus(
      @Param("enrichTrackerIds") List<Integer> enrichTrackerIds,
      @Param("enrichStatus") Integer enrichStatus);
}
