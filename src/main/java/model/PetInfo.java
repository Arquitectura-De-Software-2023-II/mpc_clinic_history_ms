package model;

import java.util.List;

public class PetInfo {
    private Float weight;
    private int age;
    private List<Disease> diseases;
    private List<Vaccine> vaccines;

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    @Override
    public String toString() {
        return "PetInfo{" +
                "weight=" + weight +
                ", age=" + age +
                ", diseases=" + diseases +
                ", vaccines=" + vaccines +
                '}';
    }
}