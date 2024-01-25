package lt.codeacademy.javau8.PoliklinikosApp.entities;

import jakarta.persistence.Entity;

@Entity
public class MedicalService {

    Long servicesID;
    String servicesTitle;
    String servicesCategory;


    // Constructors:

    public MedicalService() {}

    public MedicalService(String servicesTitle, String servicesCategory) {
        this.servicesTitle = servicesTitle;
        this.servicesCategory = servicesCategory;
    }

    public MedicalService(Long servicesID, String servicesTitle, String servicesCategory) {
        this.servicesID = servicesID;
        this.servicesTitle = servicesTitle;
        this.servicesCategory = servicesCategory;
    }

    // Getters & Setters
    public Long getServicesID() {
        return servicesID;}
    public void setServicesID(Long servicesID) {
        this.servicesID = servicesID;}

    public String getServicesCategory() {
        return servicesCategory;}
    public void setServicesCategory(String servicesCategory) {
        this.servicesCategory = servicesCategory;}

    public String getServicesTitle() {
        return servicesTitle;}
    public void setServicesTitle(String servicesTitle) {
        this.servicesTitle = servicesTitle;}

    // Methods:


    @Override
    public String toString() {
        return "MedicalService{" +
                "servicesID=" + servicesID +
                ", servicesTitle='" + servicesTitle + '\'' +
                ", servicesCategory='" + servicesCategory + '\'' +
                '}';
    }
}
