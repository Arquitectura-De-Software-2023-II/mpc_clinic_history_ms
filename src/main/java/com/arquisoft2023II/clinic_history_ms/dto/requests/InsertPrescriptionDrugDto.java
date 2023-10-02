package com.arquisoft2023II.clinic_history_ms.dto.requests;

import com.arquisoft2023II.clinic_history_ms.model.PrescriptionDrug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@ToString
public class InsertPrescriptionDrugDto {

    private String name;
    private DateDto startDate;
    private DateDto endDate;
    private String description;
    private String periodicity;

    public PrescriptionDrug toPrescriptionDrug(){
        return new PrescriptionDrug().setName(name).setStartDate(startDate.toLocaleDateTime()).setEndDate(endDate.toLocaleDateTime()).setDescription(description).setPeriodicity(periodicity);
    }
}
@AllArgsConstructor
@Data
@ToString
class DateDto{
    private int year = 0;
    private int month = 0;
    private int day = 0;
    private int hour = 0;
    private int minute = 0;
    private int second = 0;
    DateDto(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public LocalDateTime toLocaleDateTime(){
        return LocalDateTime.of(year, month, day, hour, minute, second);
    }
}

