package com.arquisoft2023II.clinic_history_ms.dto.POST;

import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.model.PetInfo;
import com.arquisoft2023II.clinic_history_ms.model.VeterinaryAppointment;
import lombok.Data;

import java.util.List;

@Data
public class CreatePetDto {
    private  String usersDBId;
    private PetInfo petInfo;

    public Pet toPet(){
        System.out.println(petInfo.toString());
        return new Pet().setUsersDBId(usersDBId).setPetInfo(petInfo);
    }
}
