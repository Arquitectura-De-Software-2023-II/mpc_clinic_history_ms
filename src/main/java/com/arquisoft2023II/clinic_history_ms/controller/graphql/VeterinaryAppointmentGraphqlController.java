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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class VeterinaryAppointmentGraphqlController {
    private final VeterinaryAppointmentService veterinaryAppointmentService;

    @MutationMapping
    public ResponseEntity<Pet> AddDiseaseToPet(@Argument String usersDBId, @Argument CreateVeterinaryAppointmentDto veterinaryAppointmentDto){
        Pet pet = veterinaryAppointmentService.AddAppointmentToPet(usersDBId, veterinaryAppointmentDto);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
    @QueryMapping
    public ResponseEntity<List<VeterinaryAppointment>> getVeterinaryAppointments(@Argument String usersDBId){
        List<VeterinaryAppointment> veterinaryAppointments = veterinaryAppointmentService.getVeterinaryAppointments(usersDBId);
        return new ResponseEntity<>(veterinaryAppointments, HttpStatus.OK);
    }
    @QueryMapping
    public ResponseEntity<List<Pet>> getPetsByDoctorId(@Argument String doctorId){
        List<Pet> pets = veterinaryAppointmentService.getPetsByDoctorId(doctorId);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
    @MutationMapping
    public ResponseEntity<Pet> AddPrescriptionToPet(
            @Argument String usersDBId,
            @Argument String appointmentId,
            @Argument InsertPrescriptionDrugDto insertPrescriptionDrugDto
            )
    {

        Pet pet = veterinaryAppointmentService.AddPrescriptionDrugToPet(usersDBId,appointmentId, insertPrescriptionDrugDto);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
}
