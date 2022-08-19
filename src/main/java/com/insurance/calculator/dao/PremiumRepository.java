package com.insurance.calculator.dao;

import com.insurance.calculator.domain.Premium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PremiumRepository extends JpaRepository<Premium, Long> {

    List<Premium> findAll();

    Premium findByUserName(String name);
}