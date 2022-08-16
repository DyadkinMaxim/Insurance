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

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "premium", nullable = false)
    private Double premium;

    @Column(name = "mileage", nullable = false)
    private Double mileage;

    @Column(name = "type_class_factor", nullable = false)
    private Double typeClassFactor;

    @Column(name = "regional_factor", nullable = false)
    private Double regionalFactor;
}
