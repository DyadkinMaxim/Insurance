package com.insurance.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CalculatorApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CalculatorApplication.class, args);
    }
}