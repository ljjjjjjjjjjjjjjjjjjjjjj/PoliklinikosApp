
package lt.codeacademy.javau8.PoliklinikosApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MedicalService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long serviceID;
    String serviceTitle;
    String serviceCategory;


    // Constructors:

    public MedicalService() {}

    public MedicalService(String serviceTitle, String serviceCategory) {
        this.serviceTitle = serviceTitle;
        this.serviceCategory = serviceCategory;
    }

    public MedicalService(Long serviceID, String serviceTitle, String serviceCategory) {
        this.serviceID = serviceID;
        this.serviceTitle = serviceTitle;
        this.serviceCategory = serviceCategory;
    }

    // Getters & Setters
    public Long getServiceID() {
        return serviceID;}
    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;}

    public String getServiceCategory() {
        return serviceCategory;}
    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;}

    public String getServiceTitle() {
        return serviceTitle;}
    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;}

    // Methods:


    @Override
    public String toString() {
        return "MedicalService{" +
                "servicesID=" + serviceID +
                ", servicesTitle='" + serviceTitle + '\'' +
                ", servicesCategory='" + serviceCategory + '\'' +
                '}';
    }
}
