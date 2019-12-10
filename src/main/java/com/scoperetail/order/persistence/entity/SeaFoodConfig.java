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

@Data
@EqualsAndHashCode(
    callSuper = false,
    of = {"supplierId"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seafood_config")
public class SeaFoodConfig extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "supplier_id", nullable = false)
  private Long supplierId;

  @Column(name = "is_enabled", length = 1)
  private Character isEnabled;
}
