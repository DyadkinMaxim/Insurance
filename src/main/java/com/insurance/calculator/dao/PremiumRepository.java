package com.insurance.calculator.dao;

import com.insurance.calculator.domain.Premium;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PremiumRepository extends CrudRepository<Premium, Long> {

    List<Premium> findAll();

    Premium findByUserName(String name);
}