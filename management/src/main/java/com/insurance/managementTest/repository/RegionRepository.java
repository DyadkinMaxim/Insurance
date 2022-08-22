package com.insurance.managementTest.repository;

import com.insurance.managementTest.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    List<Region> findAll();

    List<Region> findByPostCode(Long postCode);
}
