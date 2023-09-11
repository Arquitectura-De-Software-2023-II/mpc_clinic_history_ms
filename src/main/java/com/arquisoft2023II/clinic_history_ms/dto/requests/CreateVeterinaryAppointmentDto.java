package com.arquisoft2023II.clinic_history_ms.dto.requests;

import com.arquisoft2023II.clinic_history_ms.model.PrescriptionDrug;
import com.arquisoft2023II.clinic_history_ms.model.ScheduledAppointment;
import com.arquisoft2023II.clinic_history_ms.model.VeterinaryAppointment;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@ToString
@Data
public class CreateVeterinaryAppointmentDto {
    private String doctorId;
    private String description;
    private List<PrescriptionDrug> prescriptionDrugs;
    private List<ScheduledAppointment> scheduledAppointments;
    public VeterinaryAppointment toVeterinaryAppointment(){
        if( prescriptionDrugs == null) {
            prescriptionDrugs = Collections.emptyList();
        }
        if( scheduledAppointments == null) {
            scheduledAppointments = Collections.emptyList();
        }
        LocalDateTime now = LocalDateTime.now();
        String id = now.toString().replace(":", "-").replace(".", "-");
        return new VeterinaryAppointment().setAppointmentDate(now).setId(id).setDoctorId(doctorId).setDescription(description).setPrescriptionDrugs(prescriptionDrugs).setScheduledAppointments(scheduledAppointments);
    }

}
