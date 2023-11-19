package com.intecbrussel.bankingclientsservice.clients.service;



import com.intecbrussel.bankingclientsservice.clients.model.Individual;
import com.intecbrussel.commonsservice.dto.IndividualDTO;
import org.mapstruct.Mapper;

// interface contain the method signatures for mapping between DTOs and entities.
@Mapper(componentModel = "spring")
public interface IndividualMapper {

    IndividualDTO toDTO(Individual individual);
    Individual toIndividual(IndividualDTO individualDTO);
}
