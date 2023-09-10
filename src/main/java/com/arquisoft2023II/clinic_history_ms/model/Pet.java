package com.arquisoft2023II.clinic_history_ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Accessors(chain = true)
@Data
@Document(collection = "Pets")
@ToString
@NoArgsConstructor
public class Pet {
    @MongoId()
    private String id;
    @Indexed(unique = true)
    private String usersDBId;
    private PetInfo petInfo;
    private List<VeterinaryAppointment> veterinaryAppointments;

    public Pet(String usersDBId, PetInfo petInfo) {
        this.usersDBId = usersDBId;
        this.petInfo = petInfo;
    }

    public Pet(String usersDBId, PetInfo petInfo, List<VeterinaryAppointment> veterinaryAppointments) {
        this.usersDBId = usersDBId;
        this.petInfo = petInfo;
        this.veterinaryAppointments = veterinaryAppointments;
    }
}
