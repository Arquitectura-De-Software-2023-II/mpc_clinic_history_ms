package com.arquisoft2023II.clinic_history_ms.exceptions.validation;

import com.arquisoft2023II.clinic_history_ms.exceptions.ValidationErrorException;

public class PetAlreadyExistsException extends ValidationErrorException {
    public PetAlreadyExistsException(String petId){
        super(String.format("Pet '%s' already exists", petId));
    }
}
