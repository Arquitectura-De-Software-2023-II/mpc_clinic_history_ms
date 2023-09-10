package model;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

public class Vaccine {
    @Indexed
    private String name;
    private Date vaccination_date;
    private String description;
    private int duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getVaccination_date() {
        return vaccination_date;
    }

    public void setVaccination_date(Date vaccination_date) {
        this.vaccination_date = vaccination_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "name='" + name + '\'' +
                ", vaccination_date=" + vaccination_date +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}';
    }
}
