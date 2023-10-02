package com.arquisoft2023II.clinic_history_ms.exceptions.validation;

import com.arquisoft2023II.clinic_history_ms.exceptions.ValidationErrorException;

public class PetNotFoundException extends ValidationErrorException {
    public PetNotFoundException(String petId){
        super(String.format("Pet '%s' not found", petId));
    }
}
