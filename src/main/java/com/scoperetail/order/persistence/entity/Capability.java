package com.scoperetail.order.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = {"capabilityId"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "capability")
public class Capability {
  @Id
  @Column(name = "capability_id", nullable = false)
  private Integer capabilityId;

  @Column(name = "capability_label", nullable = false, length = 10)
  private String capabilityLabel;

  @Column(name = "capability_interface", nullable = true, length = 40)
  private String capabilityInterface;

  @Column(name = "capability_type", nullable = false, length = 2)
  private String capabilityType;

  @Column(name = "description", nullable = true, length = 30)
  private String desc;

  @Column(name = "timeout_duration", nullable = false)
  private Integer timeoutDuration;
}
