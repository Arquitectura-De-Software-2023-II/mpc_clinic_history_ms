package com.arquisoft2023II.clinic_history_ms.controller.graphql;

import com.arquisoft2023II.clinic_history_ms.dto.requests.CreatePetDto;
import com.arquisoft2023II.clinic_history_ms.dto.requests.UpdatePetInfoDto;
import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@AllArgsConstructor
@Controller
public class PetGraphqlController {

    private final PetService petService;

    // Basic CRUD operations to the Pet entity
    @MutationMapping
    public ResponseEntity<Pet> createPet(@Argument CreatePetDto createPetDto){

        Pet petCreated = petService.createPet(createPetDto);
        return new ResponseEntity<>(petCreated, HttpStatus.CREATED);
    }

    @QueryMapping()
    public ResponseEntity<Pet> getPetByUsersDBId(@Argument String usersDBId){
        Pet pet = petService.getPetByUsersDBId(usersDBId);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
    @QueryMapping()
    public List<Pet> getAllPets(){
        System.out.println("getAllPets");
        return petService.getAllPets();
    }
    @MutationMapping()
    public ResponseEntity<Pet> updatePetByUsersDBId(@Argument String usersDBId, @Argument UpdatePetInfoDto updatePetInfoDto){
        Pet pet = petService.updatePetByUsersDBId(usersDBId, updatePetInfoDto);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
    @MutationMapping()
    public ResponseEntity<HttpMessage> deletePetByUsersDBId(@Argument String usersDBId){
        petService.deletePetByUsersDBId(usersDBId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // End of basic CRUD operations to the Pet entity

}
