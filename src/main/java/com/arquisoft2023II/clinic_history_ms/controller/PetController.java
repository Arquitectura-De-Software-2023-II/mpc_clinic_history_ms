package com.arquisoft2023II.clinic_history_ms.controller;

import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.repository.PetRepository;
import com.arquisoft2023II.clinic_history_ms.dto.POST.CreatePetDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
    PetRepository petRepository;

    public  PetController(PetRepository petRepository){
        this.petRepository = petRepository;
    }
    @PostMapping("/pet")
    public ResponseEntity<Pet> createPet(@RequestBody CreatePetDto createPetDto){
        Pet petCreated = petRepository.save(createPetDto.toPet());
        return new ResponseEntity<>(petCreated, HttpStatus.CREATED);
    }
}
