package com.scoperetail.order.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(
    of = {"inventoryCacheId"},
    callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventory_cache")
public class InventoryCache {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "inventory_cache_id", nullable = false)
  private Integer inventoryCacheId;

  @Column(name = "supplier_id")
  private Long supplierId;

  @Column(name = "product_id")
  private Long productId;

  @Column(name = "avail_qty")
  private Integer availQty;

  @Column(name = "raw_avail_qty")
  private Integer rawAvailQty;

  @Column(name = "future_recv_qty")
  private Integer futureRecvQty;

  @UpdateTimestamp
  @Column(name = "last_modified_ts")
  private LocalDateTime lastModifiesTs;
}
