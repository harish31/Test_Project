package com.scoperetail.order.persistence.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(
    callSuper = false,
    of = {"lineNbr"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_line_enriched")
public class OrderLineEnriched extends BaseEntity {
  @Id
  @Column(name = "line_nbr", nullable = false)
  private Integer lineNbr;

  @MapsId
  @OneToOne
  @JoinColumn(name = "line_nbr")
  private OrderLine orderLine;

  @Column(name = "supplier_uom", nullable = true, length = 2)
  private String supplierUom;

  @Column(name = "supplier_product_id", nullable = true, length = 18)
  private String supplierProductId;

  @Column(name = "retail_upc", nullable = true, length = 14)
  private String retailUpc;

  @Column(name = "item_cube_volume", nullable = true, precision = 4)
  private BigDecimal itemCubeVolume;

  @Column(name = "item_unit_wt", nullable = true, precision = 4)
  private BigDecimal itemUnitWt;

  @Column(name = "whse_section_cd", nullable = true, length = 4)
  private String whseSectionCode;

  @Column(name = "ship_unit_pack_cd", nullable = true, length = 3)
  private String shipUnitPackCd;

  @Column(name = "pallet_qty", nullable = true, precision = 4)
  private BigDecimal palletQty;

  @Column(name = "ship_unit_pack_qty", nullable = true)
  private BigDecimal shipUnitPackQty;

  @Column(name = "case_qty", nullable = true, precision = 4)
  private BigDecimal caseQty;

  @Column(name = "current_item_qty", nullable = true)
  private Integer currentItemQty;

  @Column(name = "sys_adjusted_item_qty", nullable = true)
  private Integer sysAdjustedItemQty;

  @Column(name = "user_adjusted_item_qty", nullable = true)
  private Integer userAdjustedItemQty;

  @Column(name = "pallet_layer", nullable = true)
  private Integer palletLayer;

  @Column(name = "pallet_height", nullable = true)
  private Integer palletHeight;

  @Column(name = "cube", nullable = true, precision = 4)
  private BigDecimal cube;

  @Column(name = "unit_wt", nullable = true, precision = 4)
  private BigDecimal unitWt;

  @Column(name = "conv_factor", nullable = true, precision = 4)
  private BigDecimal convFactor;

  @Column(name = "case_upc", nullable = true, length = 14)
  private String caseUpc;

  @Column(name = "supplier_upc", nullable = true, length = 14)
  private String supplierUpc;

  @Column(name = "supplier_upc_desc", nullable = true, length = 60)
  private String supplierUpcDesc;

  @Column(name = "product_desc", nullable = true, length = 60)
  private String productDesc;

  @Column(name = "restricted_states", nullable = true, length = 200)
  private String restrictedStates;

  @Column(name = "allowed_customer_type_ids", nullable = true, length = 20)
  private String allowedCustomerTypeIds;

  @Column(name = "product_supp_status_rsn", nullable = true, length = 100)
  private String productSuppStatusRsn;

  @Column(name = "product_supp_status_id", nullable = true)
  private Integer productSuppStatusId;

  @Column(name = "product_cust_status_id", nullable = true)
  private Integer productCustStatusId;

  @Column(name = "product_cust_status_rsn", nullable = true, length = 100)
  private String productCustStatusRsn;

  @Column(name = "product_cust_restriction_cd", nullable = true, length = 1)
  private Character productCustRestrictionCd;

  @Column(name = "prod_supp_pack", nullable = true, length = 10)
  private String packDesc;

  @Column(name = "prod_supp_size", nullable = true, length = 10)
  private String packSize;

  @Column(name = "container_wgt", nullable = true, precision = 4)
  private BigDecimal containerWeight;

  @Column(name = "cubic_feet_container", nullable = true, precision = 4)
  private BigDecimal cubicFeetContainer;

  @Column(name = "round_up_to_container")
  private Character roundUptoContainer;

  @Column(name = "no_of_container_per_pallet", nullable = true, precision = 4)
  private BigDecimal noOfContainerPerPallet;

  @Column(name = "round_up_to_pallet")
  private Character roundUptoPallet;

  @Column(name = "container_cube", nullable = true, precision = 4)
  private BigDecimal containerCube;

  @Column(name = "container_cube_route")
  private Character containerCubeRoute;

  @Column(name = "item_container_count", nullable = true, precision = 4)
  private BigDecimal itemContainerCount;

  @Column(name = "item_container_wgt", nullable = true, precision = 4)
  private BigDecimal itemContainerWgt;

  @Column(name = "item_container_pallet", nullable = true, precision = 4)
  private BigDecimal itemContainerPallet;

  @Column(name = "item_container_cube_volume", nullable = true, precision = 4)
  private BigDecimal itemContainerCubeVolume;
  
  @Column(name = "retail_section_code", nullable = true, length = 4)
  private String retailSectionCode;

  @Column(name = "subs_type_id")
  private Integer substitutionType;
  
  @Column(name = "is_restricted")
  private Boolean isRestricted;

  @ManyToOne
  @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
  private SupplierOrder supplierOrder;
  
  @Column(name = "min_qty_rule_violation")
  private Long minQtyRuleViolation;
  
  @Column(name = "max_qty_rule_violation")
  private Long maxQtyRuleViolation;
}
