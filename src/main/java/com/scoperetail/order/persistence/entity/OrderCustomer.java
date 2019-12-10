package com.scoperetail.order.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "order_customer")
public class OrderCustomer extends BaseCreateTsEntity {

  @Id
  @Column(name = "order_id")
  private Integer orderId;

  @MapsId
  @OneToOne
  @JoinColumn(name = "order_id")
  private SupplierOrder supplierOrder;

  @Column(name = "division_id", nullable = true, length = 2)
  private String divisionId;

  @Column(name = "customer_id", nullable = true)
  private Long customerId;

  @Column(name = "cust_type_id", nullable = true)
  private Integer custTypeId;

  @Column(name = "full_name", nullable = true, length = 50)
  private String customerName;

  @Column(name = "cog_id", nullable = true)
  private Integer cogId;

  @Column(name = "cog_label", nullable = true, length = 40)
  private String cogLabel;

  @Column(name = "crg_id", nullable = true)
  private Integer crgId;
  
  @Column(name = "crg_ids", nullable = true, length = 255)
  private String crgIds;

  @Column(name = "crg_label", nullable = true, length = 40)
  private String crgLabel;
  
  @Column(name = "state", nullable = true, length = 2)
  private String state;
  
  @Column(name = "customer_acc_id", nullable = true, length = 10)
  private String customerAccId;
}
