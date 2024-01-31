
package lt.codeacademy.javau8.PoliklinikosApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long patientID;

    String patientName;
    String patientSurname;
    String patientAddress;
    String patientPhone;
    String patientEmail;
    String patientCategory;

    // Lists & Objects:
    @JsonIgnore
    @OneToMany(mappedBy = "appPatient")
    List<Appointment> patientAppointments;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "products_patients",
            joinColumns = @JoinColumn(name = "patientID"),
            inverseJoinColumns = @JoinColumn(name = "productID"))
    List<MedicalProduct> patientMedicalProducts;



    // Upcoming_Updates: List of Patients
    /*
    @ManyToMany(mappedBy = "empPatients")
    private List<Employee> patientEmployees;
    */


    // Constructors:

    public Patient() {
    }

    public Patient(String patientName, String patientSurname) {
        this.patientName = patientName;
        this.patientSurname = patientSurname;
    }

    public Patient(Long patientID, String patientName, String patientSurname) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
    }

    public Patient(String patientName, String patientSurname, String patientAddress, String patientPhone,  String patientEmail, String patientCategory) {
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientAddress = patientAddress;
        this.patientPhone = patientPhone;
        this.patientEmail = patientEmail;
        this.patientCategory = patientCategory;
    }

    public Patient(Long patientID, String patientName, String patientSurname, String patientAddress, String patientPhone,  String patientEmail, String patientCategory) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientAddress = patientAddress;
        this.patientPhone = patientPhone;
        this.patientEmail = patientEmail;
        this.patientCategory = patientCategory;
    }

    // Getters & Listters:

    public Long getPatientID() {
        return patientID;
    }
    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }
    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }


    public String getPatientAddress() {
        return patientAddress;}
    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;}

    public String getPatientPhone() {
        return patientPhone;}
    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;}

    public String getPatientEmail() {
        return patientEmail;}
    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;}

    public String getPatientCategory() {
        return patientCategory;
    }
    public void setPatientCategory(String patientCategory) {
        this.patientCategory = patientCategory;
    }


    // Lists & objects Getters & Listters:

    public List<Appointment> getPatientAppointments() {
        return patientAppointments;}
    public void setPatientAppointments(List<Appointment> patientAppointments) {
        this.patientAppointments = patientAppointments;}


    public List<MedicalProduct> getPatientMedicalProducts() {
        return patientMedicalProducts;}
    public void setPatientMedicalProducts(List<MedicalProduct> patientMedicalProducts) {
        this.patientMedicalProducts = patientMedicalProducts;}







    // Methods:

    public void addMedicalProducts(MedicalProduct medicalProduct) {
        if(patientMedicalProducts==null){
            patientMedicalProducts = new ArrayList<>();
        } patientMedicalProducts.add(medicalProduct);
    }


    public void addAppointments(Appointment appointment) {
        if(patientAppointments==null){
            patientAppointments = new ArrayList<>();
        } patientAppointments.add(appointment);
    }


}
