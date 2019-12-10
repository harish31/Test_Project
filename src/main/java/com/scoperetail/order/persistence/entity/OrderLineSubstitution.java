package com.scoperetail.order.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
    of = {"substitutionId", "productId", "orderLine"},
    callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_line_substitution")
public class OrderLineSubstitution extends BaseCreateTsEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sub_id", nullable = false)
  private Integer substitutionId;

  @Column(name = "product_id", nullable = false)
  private Long productId;

  @Column(name = "supplier_product_id", nullable = true, length = 18)
  private String supplierProductId;
  
  @Column(name = "retail_upc", nullable = true, length = 14)
  private String retailUpc;

  @Column(name = "subs_factor", nullable = true, precision = 2)
  private BigDecimal subsFactor;

  @Column(name = "subs_ordered_qty", nullable = false)
  private Integer subsOrderedQty;

  @Column(name = "rank", nullable = false)
  private Integer rank;

  @Column(name = "subs_type_id", nullable = false)
  private Integer subsTypeId;

  @Column(name = "sub_product_desc", nullable = true, length = 60)
  private String subProductDesc;

  @ManyToOne
  @JoinColumn(name = "line_nbr", referencedColumnName = "line_nbr", nullable = false)
  private OrderLine orderLine;

  @ManyToOne
  @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
  private SupplierOrder supplierOrder;
}
