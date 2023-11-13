package com.arquisoft2023II.clinic_history_ms.dto.requests;

import com.arquisoft2023II.clinic_history_ms.model.Vaccine;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@ToString
public class AddVaccineDto {

    private String name;
    private int vaccination_year;
    private String description;
    private int duration;

    public Vaccine toVaccine(){
        System.out.println("toVaccine");
        System.out.println(toString());
        return new Vaccine(name, vaccination_year, description, duration);
    }
}
