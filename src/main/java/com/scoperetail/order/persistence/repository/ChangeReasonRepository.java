package com.scoperetail.order.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scoperetail.order.persistence.entity.ChangeReason;

public interface ChangeReasonRepository extends JpaRepository<ChangeReason, Integer> {}
