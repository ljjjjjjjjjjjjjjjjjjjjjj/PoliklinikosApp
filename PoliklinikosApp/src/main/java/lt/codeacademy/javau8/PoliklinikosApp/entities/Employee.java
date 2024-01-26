
package lt.codeacademy.javau8.PoliklinikosApp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long empID;

    String empName;
    String empSurname;
    String empContactInfo;
    String empCategory;


    // Lists & Objects:

    @ManyToMany
    @JoinTable(name = "productEmployees_empMedicalProducts",
            joinColumns = @JoinColumn(name = "empID"),
            inverseJoinColumns = @JoinColumn(name = "productID"))
    List<MedicalProduct> empMedicalProducts;

    @OneToMany(mappedBy = "appEmployee")
    List<Appointment> empAppointments;

    // Upcoming_Updates: List of Patients
    /*
    @ManyToMany
    @JoinTable(name = "patientEmployees_empPatients",
            joinColumns = @JoinColumn(name = "empID"),
            inverseJoinColumns = @JoinColumn(name = "patientID"))
    List<Patient> empPatients;
    */
    // Upcoming_Updates: List of MedicalRecords
    /*
    @OneToMany(mappedBy = "recordEmployee")
    List<MedicalRecord> empMedicalRecords;
    */


    // Constructors:
    public Employee() {}

    public Employee(String empName, String empSurname, String empCategory) {
        this.empName = empName;
        this.empSurname = empSurname;
        this.empCategory = empCategory;
    }

    public Employee(Long empID, String empName, String empSurname, String empCategory) {
        this.empID = empID;
        this.empName = empName;
        this.empSurname = empSurname;
        this.empCategory = empCategory;
    }

    public Employee(String empName, String empSurname, String empContactInfo, String empCategory) {
        this.empName = empName;
        this.empSurname = empSurname;
        this.empContactInfo = empContactInfo;
        this.empCategory = empCategory;

    }

    public Employee(Long empID, String empName, String empSurname, String empContactInfo, String empCategory) {
        this.empID = empID;
        this.empName = empName;
        this.empSurname = empSurname;
        this.empContactInfo = empContactInfo;
        this.empCategory = empCategory;

    }




    // Getters & Setters:

    public Long getEmpID() {
        return empID;}
    public void setEmpID(Long empID) {
        this.empID = empID;}

    public String getEmpName() {
        return empName;}
    public void setEmpName(String empName) {
        this.empName = empName;}

    public String getEmpSurname() {
        return empSurname;}
    public void setEmpSurname(String empSurname) {
        this.empSurname = empSurname;}

    public String getEmpContactInfo() {
        return empContactInfo;}
    public void setEmpContactInfo(String empContactInfo) {
        this.empContactInfo = empContactInfo;}

    public String getEmpCategory() {
        return empCategory;}
    public void setEmpCategory(String empCategory) {
        this.empCategory = empCategory;}


    // Lists & objects Getters & Setters:

    public List<MedicalProduct> getEmpMedicalProducts() {
        return empMedicalProducts;}
    public void setEmpMedicalProducts(List<MedicalProduct> empMedicalProducts) {
        this.empMedicalProducts = empMedicalProducts;}

    public List<Appointment> getEmpAppointments() {
        return empAppointments;}
    public void setEmpAppointments(List<Appointment> empAppointments) {
        this.empAppointments = empAppointments;}


    // Upcoming_Updates: List of Patients
    /*
    public List<Patient> getEmpPatients() {
        return empPatients;}
    public void setEmpPatients(List<Patient> empPatients) {
        this.empPatients = empPatients;}
    */

    // Upcoming_Updates:MedicalRecord
    /*
    public List<Upcoming_Updates_MedicalRecord> getEmpMedicalRecords() {
        return empMedicalRecords;}

    public void setEmpMedicalRecords(List<Upcoming_Updates_MedicalRecord> empMedicalRecords) {
        this.empMedicalRecords = empMedicalRecords;}
   */



    // Methods:

    public void addMedicalProducts(MedicalProduct medicalProduct) {
        if(empMedicalProducts==null){
            empMedicalProducts = new ArrayList<>();
        } empMedicalProducts.add(medicalProduct);
    }


    public void addAppointments(Appointment appointment) {
        if(empAppointments==null){
            empAppointments = new ArrayList<>();
        } empAppointments.add(appointment);
    }


    // Upcoming_Updates: List of Patients
    /*
    public void addPatients(Patient patient) {
        if(empPatients==null){
            empPatients = new ArrayList<>();
        } empPatients.add(patient);
    }
    */
    // Upcoming_Updates: List of Patients
    /*
    public void addMedicalRecordss(Upcoming_Updates_MedicalRecord medicalRecord) {
        if(empMedicalRecords==null){
            empMedicalRecords = new ArrayList<>();
        } empMedicalRecords.add(medicalRecord);
    }
    */



}
