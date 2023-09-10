package model;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

public class PrescriptionDrug {
    @Indexed
    private String name;
    @Indexed
    private Date starDate;
    @Indexed
    private Date enDate;
    private String description;
    private String periodicity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEnDate() {
        return enDate;
    }

    public void setEnDate(Date enDate) {
        this.enDate = enDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "PrescriptionDrug{" +
                "name='" + name + '\'' +
                ", starDate=" + starDate +
                ", enDate=" + enDate +
                ", drugDescription='" + description + '\'' +
                ", periodicity='" + periodicity + '\'' +
                '}';
    }
}
