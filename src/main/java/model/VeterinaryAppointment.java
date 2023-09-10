package model;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;
import java.util.List;

public class VeterinaryAppointment {
    @Indexed
    private Date appointmentDate;
    @Indexed
    private String doctorId;
    private String description;
    private List<PrescriptionDrug> prescriptionDrugs;
    private List<ScheduledAppointment> scheduledAppointments;

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PrescriptionDrug> getPrescriptionDrugs() {
        return prescriptionDrugs;
    }

    public void setPrescriptionDrugs(List<PrescriptionDrug> prescriptionDrugs) {
        this.prescriptionDrugs = prescriptionDrugs;
    }

    public List<ScheduledAppointment> getScheduledAppointments() {
        return scheduledAppointments;
    }

    public void setScheduledAppointments(List<ScheduledAppointment> scheduledAppointments) {
        this.scheduledAppointments = scheduledAppointments;
    }

    @Override
    public String toString() {
        return "VeterinaryAppointment{" +
                "appointmentDate=" + appointmentDate +
                ", doctorId='" + doctorId + '\'' +
                ", appointmentDescription='" + description + '\'' +
                ", prescriptionDrugs=" + prescriptionDrugs +
                ", scheduledAppointments=" + scheduledAppointments +
                '}';
    }
}
