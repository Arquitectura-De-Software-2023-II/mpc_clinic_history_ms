package model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "Pets")
public class Pet {
    @MongoId(FieldType.OBJECT_ID)
    private  String id;
    private PetInfo petInfo;
    private List<VeterinaryAppointment> veterinaryAppointments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PetInfo getPetInfo() {
        return petInfo;
    }

    public void setPetInfo(PetInfo petInfo) {
        this.petInfo = petInfo;
    }

    public List<VeterinaryAppointment> getVeterinaryAppointments() {
        return veterinaryAppointments;
    }

    public void setVeterinaryAppointments(List<VeterinaryAppointment> veterinaryAppointments) {
        this.veterinaryAppointments = veterinaryAppointments;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", petInfo=" + petInfo +
                ", veterinaryAppointments=" + veterinaryAppointments +
                '}';
    }
}
