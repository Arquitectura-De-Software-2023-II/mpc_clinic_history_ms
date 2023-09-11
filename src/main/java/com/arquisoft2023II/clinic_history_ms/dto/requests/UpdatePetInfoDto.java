package com.arquisoft2023II.clinic_history_ms.dto.requests;

import com.arquisoft2023II.clinic_history_ms.model.Disease;
import com.arquisoft2023II.clinic_history_ms.model.PetInfo;
import com.arquisoft2023II.clinic_history_ms.model.Vaccine;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UpdatePetInfoDto {
    private Float weight;
    private int age;
    private List<Disease> diseases;
    private List<Vaccine> vaccines;

     public PetInfo toPetInfo(){
         System.out.println("UpdatePetInfoDto: " + this.toString());
        return new PetInfo().setAge(age).setWeight(weight).setDiseases(diseases).setVaccines(vaccines);
    }
}
