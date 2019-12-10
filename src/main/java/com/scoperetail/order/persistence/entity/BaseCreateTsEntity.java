package com.scoperetail.order.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseCreateTsEntity {
    public static final String SYSTEM = "SYSTEM";

    @CreationTimestamp
    @Column(name = "create_ts")
    private LocalDateTime createTs;
}
