package com.scoperetail.order.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.scoperetail.order.persistence.entity.EnrichSequence;

public interface EnrichSequenceRepository extends JpaRepository<EnrichSequence, Integer> {

  @EntityGraph(attributePaths = {"capability"})
  List<EnrichSequence> findByOrderTypeIdAndSuppTypeIdAndCustTypeIdOrderBySeqNum(
      Integer orderTypeId, Integer suppTypeId, Integer custTypeId);
}
