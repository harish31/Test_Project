package com.scoperetail.order.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@EqualsAndHashCode(of = {"enrichSequenceId"})
@AllArgsConstructor
@Entity
@Table(name = "enrich_sequence")
public class EnrichSequence {
  @Id
  @Column(name = "enrich_sequence_id")
  private Integer enrichSequenceId;

  @Column(name = "order_type_id", nullable = false)
  private Integer orderTypeId;

  @Column(name = "supp_type_id", nullable = false)
  private Integer suppTypeId;

  @Column(name = "cust_type_id", nullable = false)
  private Integer custTypeId;

  @Column(name = "seq_num", nullable = false)
  private Integer seqNum;

  @ManyToOne
  @JoinColumn(name = "capability_id", nullable = false)
  private Capability capability;
}
