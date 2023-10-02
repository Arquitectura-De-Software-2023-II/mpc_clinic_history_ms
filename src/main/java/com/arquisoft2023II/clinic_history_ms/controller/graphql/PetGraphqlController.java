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
    public Pet createPet(@Argument CreatePetDto createPetDto){

        return petService.createPet(createPetDto);
    }

    @QueryMapping()
    public Pet getPetByUsersDBId(@Argument String usersDBId){
        return petService.getPetByUsersDBId(usersDBId);
    }
    @QueryMapping()
    public List<Pet> getAllPets(){
        System.out.println("getAllPets");
        return petService.getAllPets();
    }
    @MutationMapping()
    public Pet updatePetByUsersDBId(@Argument String usersDBId, @Argument UpdatePetInfoDto updatePetInfoDto){
        return petService.updatePetByUsersDBId(usersDBId, updatePetInfoDto);
    }
    @MutationMapping()
    public Pet deletePetByUsersDBId(@Argument String usersDBId){
        return petService.deletePetByUsersDBId(usersDBId);

    }
    // End of basic CRUD operations to the Pet entity

}
