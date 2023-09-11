package com.arquisoft2023II.clinic_history_ms.dto.requests;

import com.arquisoft2023II.clinic_history_ms.model.PrescriptionDrug;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class InsertPrescriptionDrugDto {

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private String periodicity;

    public PrescriptionDrug toPrescriptionDrug(){
        return new PrescriptionDrug().setName(name).setStartDate(startDate).setEndDate(endDate).setDescription(description).setPeriodicity(periodicity);
    }
}
