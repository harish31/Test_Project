package com.scoperetail.order.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scoperetail.order.persistence.entity.AdjustmentReason;

@Repository
public interface AdjustmentReasonRepository extends JpaRepository<AdjustmentReason, Integer> {}
