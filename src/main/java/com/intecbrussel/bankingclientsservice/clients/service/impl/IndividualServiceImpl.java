package com.intecbrussel.bankingclientsservice.clients.service.impl;

import com.intecbrussel.bankingclientsservice.clients.dto.IndividualDTO;
import com.intecbrussel.bankingclientsservice.clients.model.Individual;
import com.intecbrussel.bankingclientsservice.clients.repository.IndividualRepository;
import com.intecbrussel.bankingclientsservice.clients.service.IndividualMapper;
import com.intecbrussel.bankingclientsservice.clients.service.IndividualService;
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
        Optional<Individual> individualRepositoryById = individualRepository.findById(id);
        if (individualRepositoryById.isPresent()) {
            IndividualDTO individualMapperDTO = individualMapper.toDTO(individualRepositoryById.get());
            individualMapperDTO.updateWith(individualDTO);
            return Optional.of(individualMapperDTO);
        }

        return Optional.empty();
    }
}
