package com.insurance.managementTest.domain;

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

    @CreatedDate
    @Column(name = "created_on", updatable = false)
    private Timestamp createdOn;

    @LastModifiedDate
    @Column(name = "updated_on", nullable = false)
    private Timestamp updatedOn;
}
