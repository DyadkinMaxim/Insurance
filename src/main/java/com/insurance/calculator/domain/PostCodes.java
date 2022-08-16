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
@Table(name = "post_codes")
public class PostCodes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "post_code", nullable = false)
    private long postCode;

    @Column(name = "federal_state", nullable = false)
    private String federalState;

    @Column(name = "county", nullable = false)
    private String county;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "value", nullable = false)
    private Double value;
}
