package com.intecbrussel.bankingclientsservice.clients.repository;

import com.intecbrussel.bankingclientsservice.clients.model.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Integer> {
}
