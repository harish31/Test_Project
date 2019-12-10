package com.scoperetail.order.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"enrichTrackerId"})
@Entity
@Table(name = "enrich_tracker")
public class EnrichTracker extends BaseEntity {

  private static final long serialVersionUID = -5246706973633929088L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "enrich_tracker_id", nullable = false)
  private Integer enrichTrackerId;

  @Column(name = "order_id", nullable = false)
  private Integer orderId;

  @Column(name = "enrich_status_id", nullable = true)
  private Integer enrichStatusId;

  @Column(name = "enrich_sequence", nullable = false)
  private Integer enrichSequence;

  @Column(name = "retry_count", nullable = false)
  private Integer retryCount;

  @Column(name = "capability_time_out", nullable = true)
  private LocalDateTime capabilityTimeOut;

  @ManyToOne
  @JoinColumn(name = "capability_id")
  private Capability capability;
}
