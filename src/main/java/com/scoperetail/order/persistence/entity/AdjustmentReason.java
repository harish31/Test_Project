package com.scoperetail.order.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.scoperetail.order.persistence.entity.ChangeReason.ChangeReasonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "adjustmentReasonId")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adjustment_reason")
public class AdjustmentReason {

	@Id
	@Column(name = "adj_reason_id", nullable = false)
	private Integer adjustmentReasonId;

	@Column(name = "adj_reason_cd", nullable = false, length = 10)
	private String adjustmentReasonCd;

	@Column(name = "description", nullable = true, length = 50)
	private String description;

}
