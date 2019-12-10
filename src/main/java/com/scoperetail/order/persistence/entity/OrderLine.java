package com.scoperetail.order.persistence.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(
    of = {"lineNbr", "productId", "origProductId"},
    callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_line")
public class OrderLine extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "line_nbr", nullable = false)
  private Integer lineNbr;

  @Column(name = "change_reason_id")
  private Integer changeReasonId;

  @Column(name = "order_line_status_id", nullable = false)
  private Integer orderLineStatusId;

  @Column(name = "product_id", nullable = false)
  private Long productId;

  @Column(name = "orig_product_id", nullable = false, insertable = true, updatable = false)
  private Long origProductId;

  @Column(name = "ordered_item_qty", nullable = false)
  private Integer orderedItemQty;

  @Column(name = "ordered_item_wgt", nullable = true, precision = 2)
  private BigDecimal orderedItemWgt;

  @Column(name = "ordered_uom", nullable = true, length = 2)
  private String orderedUom;
  
  @Column(name = "rejct_rsn_code")
  private Integer rejectReasonCode;

  @ManyToOne
  @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
  private SupplierOrder supplierOrder;

  @OneToOne(
      mappedBy = "orderLine",
      cascade = {CascadeType.ALL})
  private OrderLineEnriched orderLineEnriched;

  @OneToMany(
      mappedBy = "orderLine",
      cascade = {CascadeType.ALL})
  @OrderBy("adjustmentId ASC")
  private Set<OrderLineAdjustment> orderLineAdjustments;

  @OneToMany(
      mappedBy = "orderLine",
      cascade = {CascadeType.ALL})
  private Collection<OrderLineReplacement> orderLineReplacements;

  @OneToMany(
      mappedBy = "orderLine",
      cascade = {CascadeType.ALL})
  private Set<OrderLineSubstitution> orderLineSubstitutions;
  @Column(name = "expired_product_id", nullable = true)
  private Long expiredProductId;
}
