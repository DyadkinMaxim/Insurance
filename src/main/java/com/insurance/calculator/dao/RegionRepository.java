package com.insurance.calculator.dao;

import com.insurance.calculator.domain.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region, Long> {

    List<Region> findAll();

    Region findByPostCode(long postCode);
}
