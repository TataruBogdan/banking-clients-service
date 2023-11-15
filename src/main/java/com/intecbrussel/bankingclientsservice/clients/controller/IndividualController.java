package com.intecbrussel.bankingclientsservice.clients.controller;

import com.intecbrussel.bankingclientsservice.clients.dto.IndividualDTO;
import com.intecbrussel.bankingclientsservice.clients.service.IndividualService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class IndividualController {

    private final IndividualService individualService;

    @GetMapping("/individuals")
    public List<IndividualDTO> retrieveAllIndividual() {
        return individualService.getAll();
    }

    @GetMapping("/individuals/{id}")
    public ResponseEntity<IndividualDTO> retrieveIndividual(@PathVariable int id) {

        Optional<IndividualDTO> individualById = individualService.getById(id);

        if (individualById.isPresent()){
            return ResponseEntity.ok(individualById.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/individuals/{id}")
    public void deleteIndividual(@PathVariable int id) {
        individualService.deleteById(id);
    }

    @PostMapping("/individuals/create")
    public ResponseEntity<IndividualDTO> create(@Valid @RequestBody IndividualDTO individualDTO) {
        Optional<IndividualDTO> foundIndividual = individualService.getByEmailAddress(individualDTO.getEmailAddress());

        if (foundIndividual.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(individualDTO);
        } else {
            //individualDTO.setId(null);
            individualService.save(individualDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(individualDTO);
        }
    }

    @PatchMapping("/individuals/update")
    public ResponseEntity<IndividualDTO> updateIndividual(@PathVariable @Valid int id, @RequestBody @Validated IndividualDTO individualDTO) {

        Optional<IndividualDTO> updatedIndividual = individualService.getById(individualDTO.getId());

        if (updatedIndividual.isPresent()) {
            individualService.update(id, individualDTO);
            return ResponseEntity.ok(updatedIndividual.get());
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(individualDTO);
        }

    }


}
