package com.arquisoft2023II.clinic_history_ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@ToString
@AllArgsConstructor
@Data
@NoArgsConstructor
public class VeterinaryAppointment {
    @Indexed
    private LocalDateTime appointmentDate;
    @Indexed
    private String doctorId;
    private String description;
    private List<PrescriptionDrug> prescriptionDrugs;
    private List<ScheduledAppointment> scheduledAppointments;

    public VeterinaryAppointment(LocalDateTime appointmentDate, String doctorId, String description) {
        this.appointmentDate = appointmentDate;
        this.doctorId = doctorId;
        this.description = description;
    }

}
