package com.arquisoft2023II.clinic_history_ms.controller;

import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.repository.PetRepository;
import com.arquisoft2023II.clinic_history_ms.dto.POST.CreatePetDto;
import com.arquisoft2023II.clinic_history_ms.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PetController {

    private final PetService petService;


    @PostMapping("/pet")
    public ResponseEntity<Pet> createPet(@RequestBody CreatePetDto createPetDto){

        Pet petCreated = petService.createPet(createPetDto);
        return new ResponseEntity<>(petCreated, HttpStatus.CREATED);
    }
    /*
    @GetMapping("/pet")
    public ResponseEntity<Pet> getPetByUsersDBId(@RequestBody String usersDBId){
        Pet pet = petService.getPetByUsersDBId(usersDBId);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
    */
}
