package com.arquisoft2023II.clinic_history_ms.controller.REST;

import com.arquisoft2023II.clinic_history_ms.model.Disease;
import com.arquisoft2023II.clinic_history_ms.model.Pet;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping(value = "/api/pet")
abstract public class DiseaseControllers {

    // verify if the pet has a disease with the same name before adding it
    @PostMapping(path = "{usersDBId}/disease")
    abstract public ResponseEntity<Pet> AddDiseaseToPet(@PathVariable("usersDBId") String usersDBId, @RequestBody Disease disease);
    @DeleteMapping(path = "{usersDBId}/disease/{diseaseName}")
    abstract public ResponseEntity<Pet> DeleteDiseaseFromPet(@PathVariable("usersDBId") String usersDBId, @PathVariable("diseaseName") String diseaseName);
    @GetMapping(path = "{usersDBId}/disease")
    abstract public ResponseEntity<Pet> GetDiseasesFromPet(@PathVariable("usersDBId") String usersDBId);
    @GetMapping(path = "{usersDBId}/disease/{diseaseName}")
    abstract public ResponseEntity<Disease> GetPetHasDisease(@PathVariable("usersDBId") String usersDBId, @PathVariable("diseaseName") String diseaseName);

    // verify if the pet has a disease with the same name before updating it
    @PutMapping(path = "{usersDBId}/disease/{diseaseName}")
    abstract public ResponseEntity<Pet> UpdateDiseaseFromPet(@PathVariable("usersDBId") String usersDBId, @PathVariable("diseaseName") String diseaseName, @RequestBody Disease disease);


    @GetMapping(path = "disease/{diseaseName}")
    abstract public ResponseEntity<List<Pet>> getPetByDisease(@PathVariable("diseaseName") String diseaseName, @RequestParam(defaultValue = "true") String hasDisease);

}
