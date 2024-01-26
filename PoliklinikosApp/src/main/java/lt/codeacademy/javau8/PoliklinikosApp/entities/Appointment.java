
package lt.codeacademy.javau8.PoliklinikosApp.entities;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long appID;
    String appCategory;
    String appReason;
    String appDate;
    // LocalDateTime appDate; to be updated


    //Lists & objects:

    @ManyToOne
    @JoinColumn(name = "empID")
    Employee appEmployee;

    @ManyToOne
    @JoinColumn(name = "patientID")
    Patient appPatient;

    @ManyToMany
    @JoinTable(name = "productAppointments_appMedicalProducts",
            joinColumns = @JoinColumn(name = "appID"),
            inverseJoinColumns = @JoinColumn(name = "productID"))
    List<MedicalProduct> appMedicalProducts;






    // Constructors:
    public Appointment() {}

    public Appointment(Long appID) {
        this.appID = appID;
    }

    public Appointment(Long appID, String appCategory) {
        this.appID = appID;
        this.appCategory = appCategory;
    }

    public Appointment(String appCategory, String appReason, String appDate) {
        this.appCategory = appCategory;
        this.appReason = appReason;
        this.appDate = appDate;
    }

    public Appointment(Long appID, String appCategory, String appReason, String appDate) {
        this.appID = appID;
        this.appCategory = appCategory;
        this.appReason = appReason;
        this.appDate = appDate;
    }




    // Getters & Setters
    public Long getAppID() {
        return appID;}
    public void setAppID(Long appID) {
        this.appID = appID;}

    public String getAppCategory() {
        return appCategory;}
    public void setAppCategory(String appCategory) {
        this.appCategory = appCategory;}

    public String getAppReason() {
        return appReason;}
    public void setAppReason(String appReason) {
        this.appReason = appReason;}

    public String getAppDate() {
        return appDate;}
    public void setAppDate(String appDate) {
        this.appDate = appDate;}




    // Lists & objects Getters & Setters:

    public Employee getAppEmployee() {
        return appEmployee;}
    public void setAppEmployee(Employee appEmployee) {
        this.appEmployee = appEmployee;}

    public Patient getAppPatient() {
        return appPatient;}
    public void setAppPatient(Patient appPatient) {
        this.appPatient = appPatient;}


    public List<MedicalProduct> getAppMedicalProducts() {
        return appMedicalProducts;}
    public void setAppMedicalProducts(List<MedicalProduct> appMedicalProducts) {
        this.appMedicalProducts = appMedicalProducts;}



    // Methods:
    public void addMedicalProducts(MedicalProduct medicalProduct) {
        if(appMedicalProducts==null){
            appMedicalProducts = new ArrayList<>();
        } appMedicalProducts.add(medicalProduct);
    }



}
