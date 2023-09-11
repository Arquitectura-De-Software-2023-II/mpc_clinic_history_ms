package com.arquisoft2023II.clinic_history_ms.service;

import com.arquisoft2023II.clinic_history_ms.dto.requests.CreatePetDto;
import com.arquisoft2023II.clinic_history_ms.dto.requests.UpdatePetInfoDto;
import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.model.PetInfo;
import com.arquisoft2023II.clinic_history_ms.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PetService {

    private final PetRepository petRepository;

    public Pet createPet(CreatePetDto createPetDto) {

        if (validatePetByUsersDBId(createPetDto.getUsersDBId())){
            return petRepository.insert(createPetDto.toPet());
        }
        else {
            throw new IllegalStateException("The pet has been already created");
        }
    }

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Pet getPetByUsersDBId(String usersDBId){
        Optional<Pet> pet = petRepository.findPetByUsersDBId(usersDBId);
        if (pet.isEmpty()){
            throw new IllegalStateException("The pet has not been created");
        }
        return pet.get();
    }

    public Pet updatePetByUsersDBId(String usersDBid, UpdatePetInfoDto updatePetInfoDto){
        PetInfo updatedInfo = updatePetInfoDto.toPetInfo();
        Optional<Pet> pet = petRepository.findPetByUsersDBId(usersDBid);
        if (pet.isEmpty()){
            throw new IllegalStateException("The pet has not been created");
        }
        Pet petToUpdate = pet.get().setPetInfo(updatedInfo);
        return petRepository.save(petToUpdate);
    }

    private boolean validatePetByUsersDBId(String usersDBId){
        Optional<Pet> pet= petRepository.findPetByUsersDBId(usersDBId);
        return pet.isEmpty();
    }

}
