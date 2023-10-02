package com.arquisoft2023II.clinic_history_ms.service;

import com.arquisoft2023II.clinic_history_ms.dto.requests.CreatePetDto;
import com.arquisoft2023II.clinic_history_ms.dto.requests.UpdatePetInfoDto;
import com.arquisoft2023II.clinic_history_ms.exceptions.validation.PetAlreadyExistsException;
import com.arquisoft2023II.clinic_history_ms.exceptions.validation.PetNotFoundException;
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
        String usersDBId = createPetDto.getUsersDBId();
        if (validatePetByUsersDBId(usersDBId)){
            return petRepository.insert(createPetDto.toPet());
        }
        else {
            throw new PetAlreadyExistsException(usersDBId);
        }
    }

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Pet getPetByUsersDBId(String usersDBId){
        System.out.println(usersDBId);
        Optional<Pet> pet = petRepository.findPetByUsersDBId(usersDBId);
        if (pet.isEmpty()){
            throw new PetNotFoundException(usersDBId);
        }
        return pet.get();
    }

    public Pet updatePetByUsersDBId(String usersDBid, UpdatePetInfoDto updatePetInfoDto){
        PetInfo updatedInfo = updatePetInfoDto.toPetInfo();
        Optional<Pet> pet = petRepository.findPetByUsersDBId(usersDBid);
        if (pet.isEmpty()){
            throw new PetNotFoundException(usersDBid);
        }
        Pet petToUpdate = pet.get().setPetInfo(updatedInfo);
        return petRepository.save(petToUpdate);
    }

    public void deletePetByUsersDBId(String usersDBId){
        Optional<Pet> pet = petRepository.findPetByUsersDBId(usersDBId);
        if (pet.isEmpty()){
            throw new PetNotFoundException(usersDBId);
        }
        Pet petToDelete = pet.get();
        petRepository.deleteById(petToDelete.getId());
    }

    private boolean validatePetByUsersDBId(String usersDBId){
        Optional<Pet> pet= petRepository.findPetByUsersDBId(usersDBId);
        return pet.isEmpty();
    }

}
