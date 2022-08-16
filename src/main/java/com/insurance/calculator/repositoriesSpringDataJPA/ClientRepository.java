package com.insurance.calculator.repositoriesSpringDataJPA;

import com.insurance.calculator.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByLogin(String login);
}
