package com.arquisoft2023II.clinic_history_ms.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
@ToString
public class ScheduledAppointment {
    @Indexed
    private String specialist;
    private  String description;
    @Indexed
    @Field(targetType = FieldType.STRING)
    private AppointmentPriority priority;

}
