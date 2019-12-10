package com.scoperetail.order.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseEntity extends BaseCreateEntity implements Serializable {


  @UpdateTimestamp
  @Column(name = "last_modified_ts")
  @JsonIgnore
  private LocalDateTime lastModifiedTs;

  @Column(name = "last_modified_by", length = 10)
  @JsonIgnore
  private String lastModifiedBy = SYSTEM;
}
