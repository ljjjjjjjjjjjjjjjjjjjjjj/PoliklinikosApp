
package lt.codeacademy.javau8.PoliklinikosApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

@Entity
public class MedicalProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long productID;
    String productTitle;
    String productCategory;


    // Lists & Objects:
    @JsonIgnore
    @ManyToMany(mappedBy = "empMedicalProducts", cascade = CascadeType.PERSIST)
    private List<Employee> productEmployees;



    @JsonIgnore
    @ManyToMany(mappedBy = "patientMedicalProducts")
    private List<Patient> productPatients;

    @JsonIgnore
    @ManyToMany(mappedBy = "appMedicalProducts")
    private List<Appointment> productAppointments;




    // Constructors:
    public MedicalProduct() {}

    public MedicalProduct(String productTitle, String productCategory) {
        this.productTitle = productTitle;
        this.productCategory = productCategory;
    }

    public MedicalProduct(Long productID, String productTitle, String productCategory) {
        this.productID = productID;
        this.productTitle = productTitle;
        this.productCategory = productCategory;
    }

    // Getters & Listters
    public Long getProductID() {
        return productID;}
    public void setProductID(Long productID) {
        this.productID = productID;}

    public String getProductCategory() {
        return productCategory;}
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;}

    public String getProductTitle() {
        return productTitle;}
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;}


    // Lists & objects Getters & Listters:

    public List<Employee> getProductEmployees() {
        return productEmployees;}
    public void setProductEmployees(List<Employee> productEmployees) {
        this.productEmployees = productEmployees;}

    public List<Patient> getProductPatients() {
        return productPatients;}
    public void setProductPatients(List<Patient> productPatients) {
        this.productPatients = productPatients;}

    public List<Appointment> getProductAppointments() {
        return productAppointments;}
    public void setAppAppointments(List<Appointment> productAppointments) {
        this.productAppointments = productAppointments;}




    // Methods:


    public void addEmployees(Employee employee) {
        if(productEmployees==null){
            productEmployees = new ArrayList<>();
        }
        productEmployees.add(employee);

/*

        if (employee.getEmpMedicalProducts() == null ) {
            employee.addMedicalProducts(this);
            return;
        }


        if (employee.getEmpMedicalProducts().contains(this) ) {
            return;
        } else {
            employee.addMedicalProducts(this);
        }

*/

    }


    public void addPatients(Patient patient) {
        if(productPatients==null){
            productPatients = new ArrayList<>();
        } productPatients.add(patient);
    }


    public void addAppointments(Appointment appointment) {
        if(productAppointments==null){
            productAppointments = new ArrayList<>();
        } productAppointments.add(appointment);
    }


}
