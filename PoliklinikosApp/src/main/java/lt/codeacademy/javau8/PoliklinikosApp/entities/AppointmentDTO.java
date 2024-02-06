package lt.codeacademy.javau8.PoliklinikosApp.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




public class AppointmentDTO {

    Long appID;
    String appCategory;
    String appReason;
    String appDate;

    Long appEmployee;
    Long appPatient;

    public AppointmentDTO(){}

    public AppointmentDTO(Long appID, String appCategory, String appReason, String appDate, Long appEmployee, Long appPatient) {
        this.appID = appID;
        this.appCategory = appCategory;
        this.appReason = appReason;
        this.appDate = appDate;
        this.appEmployee = appEmployee;
        this.appPatient = appPatient;
    }




    // Getters & Setters
    public Long getAppID() {
        return appID;
    }

    public void setAppID(Long appID) {
        this.appID = appID;
    }

    public String getAppCategory() {
        return appCategory;
    }

    public void setAppCategory(String appCategory) {
        this.appCategory = appCategory;
    }

    public String getAppReason() {
        return appReason;
    }

    public void setAppReason(String appReason) {
        this.appReason = appReason;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public Long getAppEmployee() {
        return appEmployee;
    }

    public void setAppEmployee(Long appEmployee) {
        this.appEmployee = appEmployee;
    }

    public Long getAppPatient() {
        return appPatient;
    }

    public void setAppPatient(Long appPatient) {
        this.appPatient = appPatient;
    }
}
