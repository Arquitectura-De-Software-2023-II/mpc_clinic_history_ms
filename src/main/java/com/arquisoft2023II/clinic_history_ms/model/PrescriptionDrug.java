package com.arquisoft2023II.clinic_history_ms.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Data
@ToString
@Accessors(chain = true)
public class PrescriptionDrug {
    @Indexed
    private String name;
    @Indexed
    private LocalDateTime startDate;
    @Indexed
    private LocalDateTime endDate;
    private String description;
    private String periodicity;
}
