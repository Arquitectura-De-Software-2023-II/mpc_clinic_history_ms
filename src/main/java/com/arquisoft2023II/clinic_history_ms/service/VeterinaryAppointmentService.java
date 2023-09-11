package com.arquisoft2023II.clinic_history_ms.service;

import com.arquisoft2023II.clinic_history_ms.dto.requests.CreateVeterinaryAppointmentDto;
import com.arquisoft2023II.clinic_history_ms.model.Disease;
import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.model.VeterinaryAppointment;
import com.arquisoft2023II.clinic_history_ms.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VeterinaryAppointmentService {

    private final PetRepository petRepository;

    public Pet AddAppointmentToPet(String usersDBId, CreateVeterinaryAppointmentDto VeterinaryAppointmentDto){
        Optional<Pet> pet = petRepository.findPetByUsersDBId(usersDBId);
        if (pet.isEmpty()){
            throw new IllegalStateException("The pet has not been created");
        }
        VeterinaryAppointment veterinaryAppointment = VeterinaryAppointmentDto.toVeterinaryAppointment();
        Pet petToSave = pet.get();
        petToSave.getVeterinaryAppointments().add(veterinaryAppointment);
        return petRepository.save(petToSave);
    }

    public List<VeterinaryAppointment> getVeterinaryAppointments(String usersDBId){
        Optional<Pet> pet = petRepository.findPetByUsersDBId(usersDBId);
        if (pet.isEmpty()){
            throw new IllegalStateException("The pet has not been created");
        }
        return pet.get().getVeterinaryAppointments();
    }

}
