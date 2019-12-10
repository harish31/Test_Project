package com.scoperetail.order.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(of = "transferTypeCd")
@Entity
@Table(name = "transfer_type")
public class TransferType {
  @Id
  @Column(name = "transfer_type_cd", nullable = false, length = 2)
  private String transferTypeCd;

  @Column(name = "description", nullable = true, length = 50)
  private String description;
}
