package com.arquisoft2023II.clinic_history_ms.repository;

import com.arquisoft2023II.clinic_history_ms.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends MongoRepository<Pet,String> {
    Optional<Pet> findPetByUsersDBId(String usersDBId);

    @Query("{\"veterinaryAppointments.doctorId\": \"?0\"}")
    List<Pet> findPetsByDoctorId(String doctorId);
}
