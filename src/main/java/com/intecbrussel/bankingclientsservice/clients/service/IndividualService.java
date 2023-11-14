package com.intecbrussel.bankingclientsservice.clients.service;

import com.intecbrussel.bankingclientsservice.clients.dto.IndividualDTO;

import java.util.List;
import java.util.Optional;

public interface IndividualService {

    List<IndividualDTO> getAll();
    Optional<IndividualDTO> getById(int id);

    void deleteById(int id);

    void save(IndividualDTO individualDTO);

    Optional<IndividualDTO> update(int id, IndividualDTO individualDTO);



}
