package com.insurance.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "federal_state", nullable = false)
    private String federalState;

    @Column(name = "county", nullable = false)
    private String county;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "post_code", nullable = false)
    private Long postCode;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "factor_value", nullable = false)
    private Double factorValue;
}
