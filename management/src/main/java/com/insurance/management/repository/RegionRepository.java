package com.insurance.management.repository;

import com.insurance.management.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    List<Region> findAll();

    List<Region> findByPostCode(Long postCode);
}
