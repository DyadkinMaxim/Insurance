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
@Table(name = "premium")
public class Premium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "premium_value", nullable = false)
    private Double premiumValue;

    @Column(name = "mileage_factor", nullable = false)
    private Double mileageFactor;

    @Column(name = "type_class_factor_id", nullable = false)
    private long typeClassFactorId;

    @Column(name = "regional_factor_id", nullable = false)
    private long regionalFactorId;
}
