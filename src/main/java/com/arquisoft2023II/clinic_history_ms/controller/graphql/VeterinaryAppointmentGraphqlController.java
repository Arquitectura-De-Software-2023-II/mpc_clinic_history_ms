package com.arquisoft2023II.clinic_history_ms.controller.graphql;

import com.arquisoft2023II.clinic_history_ms.dto.requests.CreateVeterinaryAppointmentDto;
import com.arquisoft2023II.clinic_history_ms.dto.requests.InsertPrescriptionDrugDto;
import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.model.VeterinaryAppointment;
import com.arquisoft2023II.clinic_history_ms.service.VeterinaryAppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class VeterinaryAppointmentGraphqlController {
    private final VeterinaryAppointmentService veterinaryAppointmentService;

    @MutationMapping
    public VeterinaryAppointment AddAppointment(@Argument String usersDBId, @Argument CreateVeterinaryAppointmentDto veterinaryAppointmentDto){
        return veterinaryAppointmentService.AddAppointmentToPet(usersDBId, veterinaryAppointmentDto);
    }
    @QueryMapping
    public List<VeterinaryAppointment> getVeterinaryAppointments(@Argument String usersDBId){
        return veterinaryAppointmentService.getVeterinaryAppointments(usersDBId);
    }
    @QueryMapping
    public List<Pet> getPetsByDoctorId(@Argument String doctorId){
        return veterinaryAppointmentService.getPetsByDoctorId(doctorId);
    }
    @MutationMapping
    public Pet AddPrescriptionToPet(
            @Argument String usersDBId,
            @Argument String appointmentId,
            @Argument InsertPrescriptionDrugDto insertPrescriptionDrugDto
            )
    {
        return veterinaryAppointmentService.AddPrescriptionDrugToPet(usersDBId,appointmentId, insertPrescriptionDrugDto);
    }
}
