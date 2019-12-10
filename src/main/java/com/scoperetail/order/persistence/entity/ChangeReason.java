package com.scoperetail.order.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@EqualsAndHashCode(of = {"change_reason_id"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "change_reason")
public class ChangeReason implements Serializable {
  @Id
  @Column(name = "change_reason_id", nullable = false)
  private Integer changeReasonId;

  @Column(name = "change_reason_code", nullable = false, length = 20)
  private String changeReasonCode;

  @Column(name = "description", nullable = true, length = 50)
  private String description;
}
