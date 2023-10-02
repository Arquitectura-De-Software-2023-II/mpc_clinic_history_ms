package com.arquisoft2023II.clinic_history_ms.exceptions;

public class NullValueInNonNullableFieldException extends RuntimeException{
    public NullValueInNonNullableFieldException(String message){
        super(message);
    }
}
