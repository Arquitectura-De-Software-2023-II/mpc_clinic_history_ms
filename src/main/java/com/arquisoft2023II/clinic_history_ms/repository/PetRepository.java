package com.arquisoft2023II.clinic_history_ms.repository;

import com.arquisoft2023II.clinic_history_ms.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends MongoRepository<Pet,String> {
    Optional<Pet> findPetByUsersDBId(String usersDBId);
    Optional<Long> countPetByUsersDBId(String usersDBId);
}
