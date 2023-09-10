package com.arquisoft2023II.clinic_history_ms.model;

public enum AppointmentPriority {
    HIG("hig"),
    MEDIUM("medium"),
    LOW("low");
    private final String priority;
    AppointmentPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
