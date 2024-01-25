package lt.codeacademy.javau8.PoliklinikosApp.entities;

import jakarta.persistence.Entity;

@Entity
public class Employee {


    Long empID;
    String empName;
    String empSurname;
    String empContactInfo;

    String empCategory;



    // Constructors:
    public Employee() {}

    public Employee(String empName) {
        this.empName = empName;
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




    // Methods:

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", empSurname='" + empSurname + '\'' +
                ", empContactInfo='" + empContactInfo + '\'' +
                ", empCategory='" + empCategory + '\'' +
                '}';
    }


}
