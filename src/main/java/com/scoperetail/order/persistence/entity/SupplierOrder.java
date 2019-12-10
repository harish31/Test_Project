package com.scoperetail.order.persistence.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(
    callSuper = false,
    of = {"orderId"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier_order")
public class SupplierOrder extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id", nullable = false)
  private Integer orderId;

  @Column(name = "change_reason_id")
  private Integer changeReasonId;

  @Column(name = "cust_order_id", nullable = false)
  private Integer custOrderId;

  @Column(name = "batch_id", nullable = true)
  private Integer batchId;

  @Column(name = "supplier_id", nullable = false)
  private Long supplierId;

  @Column(name = "supplier_type_id", nullable = false)
  private Integer supplierTypeId;

  @Column(name = "supplier_name", nullable = false, length = 50)
  private String supplierName;

  @Column(name = "order_type_id", nullable = false)
  private Integer orderTypeId;

  @Column(name = "order_status_id", nullable = false)
  private Integer orderStatusId;

  @Column(name = "order_sched_status_id", nullable = true)
  private Integer orderSchedStatusId;

  @Column(name = "sys_ord_release_ts", nullable = true)
  private LocalDateTime sysOrdReleaseTs;

  @Column(name = "dist_center_id", nullable = true, length = 4)
  private String distCenterId;

  @Column(name = "phys_whse_id", nullable = true, length = 4)
  private String physWhseId;

  @Column(name = "is_locked_for_edit", length = 1)
  private Character isLockedForEdit;

  @Column(name = "future_order", length = 1)
  private Character futureOrder;

  @Column(name = "supp_division_id", length = 2)
  private String suppDivisionId;

  @Column(name = "enrichment_status", nullable = false)
  private Character enrichmentStatus;
  
  @Transient
  private Long totalQuantity;

  @OneToMany(
      mappedBy = "supplierOrder",
      cascade = {CascadeType.ALL})
  private Set<OrderLine> orderLines;

  @OneToMany(
      mappedBy = "supplierOrder",
      cascade = {CascadeType.ALL})
  private Set<OrderTog> orderTogs;

  @OneToOne(
      mappedBy = "supplierOrder",
      cascade = {CascadeType.ALL})
  private SupplierOrderEnriched supplierOrderEnriched;

  @OneToOne(
      mappedBy = "supplierOrder",
      cascade = {CascadeType.ALL})
  private OrderCustomer orderCustomer;
  
  @Column(name = "veto", nullable = false, length = 1)
  private Character veto;
}
