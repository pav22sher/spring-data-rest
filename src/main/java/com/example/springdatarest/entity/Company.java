package com.example.springdatarest.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "company")
public class Company extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "inn")
    private String inn;
    @Column(name = "kpp")
    private String kpp;
}
