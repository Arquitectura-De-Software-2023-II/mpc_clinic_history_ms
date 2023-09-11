package com.arquisoft2023II.clinic_history_ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PetInfo {
    private Float weight;
    private int age;
    private List<Disease> diseases;
    private List<Vaccine> vaccines;

    public PetInfo(Float weight, int age) {
        this.weight = weight;
        this.age = age;
    }
}