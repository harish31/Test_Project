package com.scoperetail.order.persistence.entity;

import java.io.Serializable;

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
    of = {"adjustmentId", "orderLine"},
    callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_line_adjustment")
public class OrderLineAdjustment extends BaseCreateEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adj_id", nullable = false)
	private Integer adjustmentId;

	@Column(name = "adj_reason_id", nullable = false)
	private Integer adjustmentReasonId;

	@Column(name = "adj_item_qty", nullable = false)
	private Integer adjustmentItemQty;

	@Column(name = "exception_misc_text", length = 50)
	private String exceptionMiscText;

	@ManyToOne
	@JoinColumn(name = "line_nbr", referencedColumnName = "line_nbr", nullable = false)
	private OrderLine orderLine;
	
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
	private SupplierOrder supplierOrder;
}
