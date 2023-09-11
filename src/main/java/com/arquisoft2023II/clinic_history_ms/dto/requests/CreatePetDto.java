package com.arquisoft2023II.clinic_history_ms.dto.requests;

import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.model.PetInfo;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreatePetDto {
    private  String usersDBId;
    private PetInfo petInfo;

    public Pet toPet(){
        System.out.println(this.toString());
        return new Pet().setUsersDBId(usersDBId).setPetInfo(petInfo);
    }
}
