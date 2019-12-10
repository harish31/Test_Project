package com.scoperetail.order.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auto_allocation_config")
@Builder
@Data
@EqualsAndHashCode(
    callSuper = false,
    of = {"supplierId"})
@AllArgsConstructor
@NoArgsConstructor
public class AutoAllocationConfig extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;
  
  @Column(name = "supplier_id", nullable = false)
  private Long supplierId;

  @Column(name = "cutoff_offset")
  private Short cutoffOffset;

  @Column(name = "release_offset")
  private Short releaseOffset;

  @Column(name = "total_duration")
  private Short totalDuration;
}
