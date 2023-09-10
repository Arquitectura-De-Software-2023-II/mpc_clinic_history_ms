package com.arquisoft2023II.clinic_history_ms.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@ToString
public class PrescriptionDrug {
    @Indexed
    private String name;
    @Indexed
    private LocalDateTime starDate;
    @Indexed
    private LocalDateTime enDate;
    private String description;
    private String periodicity;
}
