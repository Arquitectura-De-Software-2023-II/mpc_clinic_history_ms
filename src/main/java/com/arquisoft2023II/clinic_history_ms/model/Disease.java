package com.arquisoft2023II.clinic_history_ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Accessors(chain = true)
@ToString
@AllArgsConstructor
public class Disease {
    @Indexed
    private String name;
    private LocalDateTime discoveryDate;
    private String description;

}
