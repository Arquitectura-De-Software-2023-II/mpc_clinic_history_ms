package com.arquisoft2023II.clinic_history_ms.service;

import com.arquisoft2023II.clinic_history_ms.dto.requests.AddVaccineDto;
import com.arquisoft2023II.clinic_history_ms.dto.requests.CreatePetDto;
import com.arquisoft2023II.clinic_history_ms.dto.requests.UpdatePetInfoDto;
import com.arquisoft2023II.clinic_history_ms.exceptions.DataFetchingException;
import com.arquisoft2023II.clinic_history_ms.exceptions.validation.PetAlreadyExistsException;
import com.arquisoft2023II.clinic_history_ms.exceptions.validation.PetNotFoundException;
import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.model.PetInfo;
import com.arquisoft2023II.clinic_history_ms.model.Vaccine;
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
            Pet pet = createPetDto.toPet();
            try{
                System.out.println(petRepository.insert(pet));
                return pet;
            }catch (Exception e){
                throw new DataFetchingException(e.getMessage());
            }
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
        System.out.println(usersDBid);
        PetInfo updatedInfo = updatePetInfoDto.toPetInfo();
        Optional<Pet> pet = petRepository.findPetByUsersDBId(usersDBid);
        if (pet.isEmpty()){
            throw new PetNotFoundException(usersDBid);
        }
        Pet petToUpdate = pet.get().setPetInfo(updatedInfo);
        System.out.println(petToUpdate);
        return petRepository.save(petToUpdate);
    }

    public Pet deletePetByUsersDBId(String usersDBId){
        Optional<Pet> pet = petRepository.findPetByUsersDBId(usersDBId);
        if (pet.isEmpty()){
            throw new PetNotFoundException(usersDBId);
        }
        Pet petToDelete = pet.get();
        petRepository.deleteById(petToDelete.getId());
        return petToDelete;
    }
    public Pet addVaccineToPet ( String usersDBId, AddVaccineDto vaccine){
        Optional<Pet> pet = petRepository.findPetByUsersDBId(usersDBId);
        if (pet.isEmpty()){
            throw new PetNotFoundException(usersDBId);
        }
        Pet petToUpdate = pet.get();
        petToUpdate.getPetInfo().getVaccines().add(vaccine.toVaccine());
        try{
            petRepository.save(petToUpdate);
        }catch (Exception e){
            throw new DataFetchingException("The pet has not been updated");
        }
        return petToUpdate;
    }

    private boolean validatePetByUsersDBId(String usersDBId){
        Optional<Pet> pet= petRepository.findPetByUsersDBId(usersDBId);
        return pet.isEmpty();
    }

}
