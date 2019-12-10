package com.scoperetail.order.persistence.entity;

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
@EqualsAndHashCode(
    of = {"orderTogId", "togLabel"},
    callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_tog")
public class OrderTog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_tog_id", nullable = false)
  private Integer orderTogId;

  @Column(name = "tog_label", nullable = false, length = 6)
  private String togLabel;

  @Column(name = "download_type", nullable = false, length = 15)
  private String downloadType;

  @Column(name = "class", nullable = false, length = 15)
  private String clazz;

  @Column(name = "origin", nullable = false, length = 15)
  private String origin;

  @Column(name = "destination", nullable = false, length = 15)
  private String destination;

  @ManyToOne
  @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
  private SupplierOrder supplierOrder;
}
