package com.scoperetail.order.persistence.entity;

import java.math.BigDecimal;

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
    of = {"id"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipping_pallet_cube_config")
public class ShippingPalletCubeConfig extends BaseEntity {
  private static final long serialVersionUID = 7496144038759825154L;

@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "supplier_id", nullable = false, unique=true)
  private Long supplierId;

  @Column(name = "shipping_pallet_cube", nullable = false , precision = 2)
  private BigDecimal shippingPalletCube;
}
