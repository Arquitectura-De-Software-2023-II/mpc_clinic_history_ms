package model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

public class ScheduledAppointment {
    @Indexed
    private String specialist;
    private  String description;
    @Indexed
    @Field(targetType = FieldType.STRING)
    private AppointmentPriority priority;

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppointmentPriority getPriority() {
        return priority;
    }

    public void setPriority(AppointmentPriority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ScheduledAppointment{" +
                "specialist='" + specialist + '\'' +
                ", appointmentDescription='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}
