package com.insurance.calculator.dao;

import com.insurance.calculator.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    List<Region> findAll();

    Region findByPostCode(long postCode);
}
