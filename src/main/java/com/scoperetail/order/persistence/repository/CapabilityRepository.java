package com.scoperetail.order.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scoperetail.order.persistence.entity.Capability;

public interface CapabilityRepository extends JpaRepository<Capability, Integer> {
  Capability findByCapabilityInterface(String capabilityInterface);

  public static final String FETCH_CAPABILTY_QUERY =
      "select c from EnrichSequence e inner join e.capability c where e.orderTypeId=:orderTypeId and e.suppTypeId=:suppTypeId and e.custTypeId=:custTypeId";

  @Query(value = FETCH_CAPABILTY_QUERY)
  List<Capability> findCapabiltyByEnrichSequence(
      @Param("orderTypeId") Integer orderTypeId,
      @Param("suppTypeId") Integer suppTypeId,
      @Param("custTypeId") Integer custTypeId);
}
