package com.scoperetail.order.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.scoperetail.commons.constants.Constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = {"orderId"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier_order_enriched")
public class SupplierOrderEnriched extends BaseEntity {

  @Id
  @Column(name = "order_id")
  private Integer orderId;

  @MapsId
  @OneToOne
  @JoinColumn(name = "order_id")
  private SupplierOrder supplierOrder;

  @Column(name = "src_order_id", nullable = true, length = 20)
  private String srcOrderId;

  @Column(name = "total_item_qty", nullable = true)
  private Integer totalItemQty;

  /** Is the total of original ordered item quantity */
  @Column(name = "total_ord_item_qty")
  private Integer totalOrderedItemQty;

  @Column(name = "total_item_wgt", nullable = true, precision = 4)
  private BigDecimal totalItemWgt;

  @Column(name = "total_pallet_qty", nullable = true, precision = 4)
  private BigDecimal totalPalletQty;

  @Column(name = "total_cube_volume", nullable = true, precision = 4)
  private BigDecimal totalCubeVolume;

  @Column(name = "schedule_id", nullable = true)
  private Integer scheduleId;

  @Column(name = "scheduled_cutoff_date", nullable = true)
  private LocalDate scheduledCutoffDate;

  @Column(name = "scheduled_cutoff_time", nullable = true)
  private LocalTime scheduledCutoffTime;

  @Column(name = "scheduled_release_date", nullable = true)
  private LocalDate scheduledReleaseDate;

  @Column(name = "scheduled_release_time", nullable = true)
  private LocalTime scheduledReleaseTime;

  @Column(name = "scheduled_delivery_date", nullable = true)
  private LocalDate scheduledDeliveryDate;

  @Column(name = "scheduled_process_date", nullable = true)
  private LocalDate scheduledProcessDate;

  @Column(name = "restricted_order_date", nullable = true)
  private LocalDate restrictedOrderDate;

  @Column(name = "shelf_availability_date", nullable = true)
  private LocalDate shelfAvailabilityDate;

  @Column(name = "auto_allocation_start_time")
  private LocalDateTime startTime;

  @Column(name = "auto_allocation_end_time")
  private LocalDateTime endTime;

  @Column(name = "stop_id", nullable = true)
  private Integer stopId;

  @Column(name = "route_id", nullable = true)
  private Integer routeId;

  @Column(name = "route_code", nullable = true, length = 4)
  private String routeCode;

  @Column(name = "po_ref_nbr", nullable = true, length = 10)
  private String poRefNbr;

  @Column(name = "transfer_type_cd", nullable = true, length = 2)
  private String transferTypeCd;

  @Column(name = "comment_txt", nullable = true, length = 60)
  private String comment;

  @Column(name = "total_case_qty", nullable = true, precision = 4)
  private BigDecimal totalCaseQuantity;

  @Column(name = "total_item_cntr_wgt", nullable = true, precision = 4)
  private BigDecimal totalItemCntrWgt;

  @Column(name = "total_item_cntr_pallet", nullable = true, precision = 4)
  private BigDecimal totalItemCntrPallet;

  @Column(name = "total_item_cntr_cube_volume", nullable = true, precision = 4)
  private BigDecimal totalItemCntrCubeVolume;

  @Column(name = "scheduled_rel_start_time")
  private LocalDateTime scheduledReleaseStartTime;

  @Column(name = "scheduled_rel_end_time")
  private LocalDateTime scheduledReleaseEndTime;

  @Column(name = "src_order_create_ts")
  private LocalDateTime srcOrderCreateTs;

  @Column(name = "orig_cust_line_cnt")
  private Integer origCustLineCount;

  @Column(name = "orig_supp_line_cnt")
  private Integer origSuppLineCount;

  @Column(name = "src_supp_id", nullable = true, length = 10)
  private String srcSuppId;
  
  @Column(name = "src_order_id_2", length = 19)
  private String srcOrderId2;

  @Column(name = "notify_ind", length = 1)
  private Character notifyInd = Constants.CHAR_N;
  
  @Column(name = "min_qty_rule_violation")
  private Long minQtyRuleViolation;
  
  @Column(name = "max_qty_rule_violation")
  private Long maxQtyRuleViolation;
}
