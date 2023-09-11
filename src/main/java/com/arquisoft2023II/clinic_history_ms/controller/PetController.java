package com.arquisoft2023II.clinic_history_ms.controller;

import com.arquisoft2023II.clinic_history_ms.dto.requests.UpdatePetInfoDto;
import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.dto.requests.CreatePetDto;
import com.arquisoft2023II.clinic_history_ms.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/pet")
public class PetController {

    private final PetService petService;

    // Basic CRUD operations to the Pet entity
    @PostMapping()
    public ResponseEntity<Pet> createPet(@RequestBody CreatePetDto createPetDto){

        Pet petCreated = petService.createPet(createPetDto);
        return new ResponseEntity<>(petCreated, HttpStatus.CREATED);
    }

    @GetMapping(path = "{usersDBId}")
    public ResponseEntity<Pet> getPetByUsersDBId(@PathVariable("usersDBId") String usersDBId){
        Pet pet = petService.getPetByUsersDBId(usersDBId);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> pets = petService.getAllPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
    @PutMapping(path = "{usersDBId}")
    public ResponseEntity<Pet> updatePetByUsersDBId(@PathVariable("usersDBId") String usersDBId, @RequestBody UpdatePetInfoDto updatePetInfoDto){
        Pet pet = petService.updatePetByUsersDBId(usersDBId, updatePetInfoDto);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
    @DeleteMapping(path = "{usersDBId}")
    public ResponseEntity<HttpMessage> deletePetByUsersDBId(@PathVariable("usersDBId") String usersDBId){
        petService.deletePetByUsersDBId(usersDBId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // End of basic CRUD operations to the Pet entity

}
