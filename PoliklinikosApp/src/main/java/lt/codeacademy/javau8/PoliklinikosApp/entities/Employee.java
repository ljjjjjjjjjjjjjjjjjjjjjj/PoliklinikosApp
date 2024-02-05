
package lt.codeacademy.javau8.PoliklinikosApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long empID;

    String empName;
    String empSurname;
    String empAddress;
    String empPhone;
    String empEmail;
    String empJobTitle;
    String empCategory;
    String imageUrl;


    // Lists & Objects:
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "products_employees",
            joinColumns = @JoinColumn(name = "empID"),
            inverseJoinColumns = @JoinColumn(name = "productID"))
    List<MedicalProduct> empMedicalProducts;

    @JsonIgnore
    @OneToMany(mappedBy = "appEmployee", fetch = FetchType.EAGER)
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
    public Employee() {

    }

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

    public Employee(String empName, String empSurname, String empAddress, String empPhone,  String empEmail, String empCategory) {
        this.empName = empName;
        this.empSurname = empSurname;
        this.empAddress = empAddress;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empCategory = empCategory;

    }

    public Employee(Long empID, String empName, String empSurname, String empAddress, String empPhone,  String empEmail, String empCategory,String imageUrl) {
        this.empID = empID;
        this.empName = empName;
        this.empSurname = empSurname;
        this.empAddress = empAddress;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empCategory = empCategory;
        this.imageUrl = imageUrl;

    }

    public Employee(String empName, String empSurname,String empAddress, String empPhone,  String empEmail, String empCategory, String imageUrl) {
        this.empName = empName;
        this.empSurname = empSurname;
        this.empAddress = empAddress;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empCategory = empCategory;
        this.imageUrl = imageUrl;
    }

    public Employee(String empName, String empSurname,String empAddress, String empPhone,  String empEmail, String empJobTitle, String empCategory, String imageUrl) {
        this.empName = empName;
        this.empSurname = empSurname;
        this.empAddress = empAddress;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empJobTitle = empJobTitle;
        this.empCategory = empCategory;
        this.imageUrl = imageUrl;
    }

    public Employee(Long empID, String empName, String empSurname,String empAddress, String empPhone,  String empEmail, String empJobTitle, String empCategory, String imageUrl) {
        this.empID = empID;
        this.empName = empName;
        this.empSurname = empSurname;
        this.empAddress = empAddress;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empJobTitle = empJobTitle;
        this.empCategory = empCategory;
        this.imageUrl = imageUrl;
    }



    // Getters & Listters:

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


    public String getEmpAddress() {
        return empAddress;}
    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;}

    public String getEmpPhone() {
        return empPhone;}
    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;}

    public String getEmpEmail() {
        return empEmail;}
    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;}

    public String getEmpJobTitle() {
        return empJobTitle;
    }

    public void setEmpJobTitle(String empJobTitle) {
        this.empJobTitle = empJobTitle;
    }

    public String getEmpCategory() {
        return empCategory;}
    public void setEmpCategory(String empCategory) {
        this.empCategory = empCategory;}

    public String getImageUrl() {
        return imageUrl;}
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;}


    // Lists & objects Getters & Listters:

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
        }
        empMedicalProducts.add(medicalProduct);

        /*
        if (medicalProduct.getProductEmployees().contains(this)) {
            return;
        } else {
            medicalProduct.addEmployees(this);
        }*/
    }

    public void removeMedicalProducts(MedicalProduct medicalProduct) {
        if (empMedicalProducts != null && empMedicalProducts.contains(medicalProduct)) {
            empMedicalProducts.remove(medicalProduct);
        }
    }


    public void addAppointments(Appointment appointment) {
        if(empAppointments==null){
            empAppointments = new ArrayList<>();
        }
        empAppointments.add(appointment);
        appointment.setAppEmployee(this);
    }




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
