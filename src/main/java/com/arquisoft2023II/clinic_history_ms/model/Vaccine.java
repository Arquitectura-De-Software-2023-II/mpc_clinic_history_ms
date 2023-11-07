package com.arquisoft2023II.clinic_history_ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
public class Vaccine {
    @Indexed
    private String name;
    private int vaccination_year;
    private String description;
    private int duration;
}
