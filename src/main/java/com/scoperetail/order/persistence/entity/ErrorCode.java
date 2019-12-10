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
@EqualsAndHashCode(of = {"errorCode"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "error_code")
public class ErrorCode {
  @Id
  @Column(name = "error_code", nullable = false)
  private Integer errorCode;

  @Column(name = "error_label", nullable = false, length = 50)
  private String errorLable;

  @Column(name = "severity", nullable = false, length = 1)
  private String severity;
}
