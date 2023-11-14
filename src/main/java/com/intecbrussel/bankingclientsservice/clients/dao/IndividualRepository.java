package com.intecbrussel.bankingclientsservice.clients.dao;

import com.intecbrussel.bankingclientsservice.clients.model.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends JpaRepository<Individual, Integer> {
}
