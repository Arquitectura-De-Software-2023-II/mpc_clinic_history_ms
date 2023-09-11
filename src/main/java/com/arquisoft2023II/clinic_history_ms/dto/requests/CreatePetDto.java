package com.arquisoft2023II.clinic_history_ms.dto.requests;

import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.model.PetInfo;
import lombok.Data;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

@Data
@ToString
public class CreatePetDto {
    private  String usersDBId;
    private PetInfo petInfo;

    public Pet toPet(){
        System.out.println(this.toString());
        if (this.petInfo.getDiseases() == null) {
            this.petInfo.setDiseases(Collections.emptyList());
        }
        if (this.petInfo.getVaccines() == null) {
            this.petInfo.setVaccines(Collections.emptyList());
        }
        return new Pet().setUsersDBId(usersDBId).setPetInfo(petInfo).setVeterinaryAppointments(Collections.emptyList());
    }
}
