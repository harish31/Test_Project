package com.scoperetail.order.persistence.entity;

import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = {"id"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_line_replacement")
public class OrderLineReplacement extends BaseCreateEntity implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "line_nbr", referencedColumnName = "line_nbr", nullable = false)
  private OrderLine orderLine;

  @ManyToOne
  @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
  private SupplierOrder supplierOrder;

  @Column(name = "change_reason_id")
  private Integer changeReasonId;

  @Column(name = "product_id", nullable = true)
  private Long productId;
}
