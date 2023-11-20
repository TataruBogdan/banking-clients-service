package com.intecbrussel.bankingclientsservice.clients.service.impl;


import com.intecbrussel.bankingclientsservice.clients.model.Individual;

import com.intecbrussel.bankingclientsservice.clients.repository.IndividualRepository;
import com.intecbrussel.bankingclientsservice.clients.service.IndividualMapper;
import com.intecbrussel.bankingclientsservice.clients.service.IndividualService;

import com.intecbrussel.commonsservice.dto.IndividualDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualServiceImpl implements IndividualService {

    private final IndividualRepository individualRepository;

    private final IndividualMapper individualMapper;
    @Override
    public List<IndividualDTO> getAll() {
        List<IndividualDTO> individualList = individualRepository
                .findAll()
                .stream()
                .map(individual -> individualMapper.toDTO(individual))
                .collect(Collectors.toList());
        return individualList;
    }

    @Override
    public Optional<IndividualDTO> getById(int id) {
        Optional<Individual> individualById = individualRepository.findById(id);
        if (individualById.isPresent()) {
            IndividualDTO individualDTO = individualMapper.toDTO(individualById.get());
            return Optional.of(individualDTO);
        }
        return Optional.empty();
    }

    @Override
    public Optional<IndividualDTO> getByEmailAddress(String name) {
        Optional<Individual> individualByName = individualRepository.findByEmailAddress(name);
        return individualByName.map(this::convert);
    }

    private IndividualDTO convert (Individual individual) {

        IndividualDTO individualDTO = new IndividualDTO();

        individualDTO.setId(individual.getId());
        individualDTO.setFirstName(individual.getFirstName());
        individualDTO.setLastName(individual.getLastName());
        individualDTO.setAddress(individual.getAddress());
        individualDTO.setBirthDate(individual.getBirthDate());
        individualDTO.setPhoneNumber(individual.getPhoneNumber());
        individualDTO.setEmailAddress(individual.getEmailAddress());
        individualDTO.setRrn(individual.getRrn());
        individualDTO.setEmployerName(individual.getEmployerName());
        individualDTO.setOccupation(individual.getOccupation());

        return individualDTO;
    }


    @Override
    public void deleteById(int id) {
        individualRepository.deleteById(id);
    }

    @Override
    public void save(IndividualDTO individualDTO) {
        Individual individualFromDTO = individualMapper.toIndividual(individualDTO);
        Individual savedIndividual = individualRepository.save(individualFromDTO);
        // back to DTO
        individualMapper.toDTO(savedIndividual);
    }

    @Override
    public Optional<IndividualDTO> update(int id, IndividualDTO individualDTO) {
//        Optional<Individual> updatedIndividual = individualRepository
//                .findById(id)
//                .map(individual -> individualMapper.toIndividual(individualDTO));
//        if (updatedIndividual.isPresent()) {
//            // Set the ID to the existing ID
//            updatedIndividual.get().setId(id);
//            individualRepository.save(updatedIndividual.get());
//
//            IndividualDTO updatedIndividualDTO = individualMapper.toDTO(updatedIndividual.get());
//            return Optional.of(updatedIndividualDTO);
//        }
        Individual individual = individualMapper.toIndividual(individualDTO);
        individual.setId(id);
        individualRepository.save(individual);

        return Optional.ofNullable(individualMapper.toDTO(individual));
    }
}
