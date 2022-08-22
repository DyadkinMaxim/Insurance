package com.insurance.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "premium")
public class Premium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "premium_value", nullable = false)
    private Double premiumValue;

    @Column(name = "mileage_factor", nullable = false)
    private Double mileageFactor;

    @Column(name = "type_class_factor", nullable = false)
    private double typeClassFactorId;

    @Column(name = "regional_factor", nullable = false)
    private double regionalFactorId;

    @CreatedDate
    @Column(name = "created_on", updatable = false)
    private Timestamp createdOn;

    @LastModifiedDate
    @Column(name = "updated_on", nullable = false)
    private Timestamp updatedOn;
}
