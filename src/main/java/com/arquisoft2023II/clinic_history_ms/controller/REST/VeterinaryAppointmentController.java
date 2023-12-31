package com.arquisoft2023II.clinic_history_ms.controller.REST;

import com.arquisoft2023II.clinic_history_ms.dto.requests.CreateVeterinaryAppointmentDto;
import com.arquisoft2023II.clinic_history_ms.dto.requests.InsertPrescriptionDrugDto;
import com.arquisoft2023II.clinic_history_ms.model.Pet;
import com.arquisoft2023II.clinic_history_ms.model.VeterinaryAppointment;
import com.arquisoft2023II.clinic_history_ms.service.VeterinaryAppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/pet")
public class VeterinaryAppointmentController {
    private final VeterinaryAppointmentService veterinaryAppointmentService;

    @PostMapping(path = "{usersDBId}/veterinaryAppointment")
    public ResponseEntity<VeterinaryAppointment> AddDiseaseToPet(@PathVariable("usersDBId") String usersDBId, @RequestBody CreateVeterinaryAppointmentDto veterinaryAppointmentDto){
        VeterinaryAppointment appointment = veterinaryAppointmentService.AddAppointmentToPet(usersDBId, veterinaryAppointmentDto);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }
    @GetMapping(path = "{usersDBId}/veterinaryAppointment")
    public ResponseEntity<List<VeterinaryAppointment>> getVeterinaryAppointments(@PathVariable("usersDBId") String usersDBId){
        List<VeterinaryAppointment> veterinaryAppointments = veterinaryAppointmentService.getVeterinaryAppointments(usersDBId);
        return new ResponseEntity<>(veterinaryAppointments, HttpStatus.OK);
    }
    @GetMapping(path = "/veterinaryAppointment/{doctorId}")
    public ResponseEntity<List<Pet>> getPetsByDoctorId(@PathVariable("doctorId") String doctorId){
        List<Pet> pets = veterinaryAppointmentService.getPetsByDoctorId(doctorId);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
    @PostMapping(path = "/{usersDBId}/prescriptionDrug")
    public ResponseEntity<Pet> AddPrescriptionToPet(
            @PathVariable("usersDBId") String usersDBId,
            @RequestParam("id") String appointmentId,
            @RequestBody InsertPrescriptionDrugDto insertPrescriptionDrugDto
            )
    {

        Pet pet = veterinaryAppointmentService.AddPrescriptionDrugToPet(usersDBId,appointmentId, insertPrescriptionDrugDto);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
}
