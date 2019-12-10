package com.scoperetail.order.persistence.entity;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "createdBy")
@MappedSuperclass
public class BaseCreateEntity extends BaseCreateTsEntity {
  public static final String SYSTEM = "SYSTEM";

  @Column(name = "created_by", length = 10)
  @JsonIgnore
  private String createdBy = SYSTEM;

  public void setCreatedBy(String createdBy) {
    this.createdBy = StringUtils.upperCase(createdBy, Locale.ENGLISH);
  }
}
