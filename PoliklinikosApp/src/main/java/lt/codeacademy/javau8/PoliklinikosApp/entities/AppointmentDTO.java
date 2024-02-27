package lt.codeacademy.javau8.PoliklinikosApp.entities;


public class AppointmentDTO {

    Long appID;
    String appCategory;
    String appReason;
    String appDate;



    // Employee info:
    Long appEmployeeID;
    String empName;
    String empSurname;
    String empJobTitle;
    String empCategory;


    // Patient info:
    Long appPatientID;

    String patientName;
    String patientSurname;
    Long patientNO;





    public AppointmentDTO(){}

    public AppointmentDTO(Long appID, String appCategory, String appReason, String appDate,
                          Long appEmployeeID, Long appPatientID) {
        this.appID = appID;
        this.appCategory = appCategory;
        this.appReason = appReason;
        this.appDate = appDate;
        this.appEmployeeID = appEmployeeID;
        this.appPatientID = appPatientID;
    }

    public AppointmentDTO(Long appID, String appCategory, String appReason, String appDate,
                          Long appEmployeeID,  String empName, String empSurname, String empJobTitle, String empCategory,
                          Long appPatientID) {
        this.appID = appID;
        this.appCategory = appCategory;
        this.appReason = appReason;
        this.appDate = appDate;

        this.appEmployeeID = appEmployeeID;
        this.empName = empName;
        this.empSurname = empSurname;
        this.empJobTitle = empJobTitle;
        this.empCategory = empCategory;

        this.appPatientID = appPatientID;
    }

    public AppointmentDTO(Long appID, String appCategory, String appReason, String appDate,
                          Long appEmployeeID, String empName, String empSurname, String empJobTitle, String empCategory,
                          Long appPatientID, String patientName, String patientSurname, Long patientNO) {
        this.appID = appID;
        this.appCategory = appCategory;
        this.appReason = appReason;
        this.appDate = appDate;

        this.appEmployeeID = appEmployeeID;
        this.empName = empName;
        this.empSurname = empSurname;
        this.empJobTitle = empJobTitle;
        this.empCategory = empCategory;

        this.appPatientID = appPatientID;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientNO = patientNO;
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

    public Long getAppEmployeeID() {
        return appEmployeeID;
    }

    public void setAppEmployeeID(Long appEmployeeID) {
        this.appEmployeeID = appEmployeeID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSurname() {
        return empSurname;
    }

    public void setEmpSurname(String empSurname) {
        this.empSurname = empSurname;
    }

    public String getEmpJobTitle() {
        return empJobTitle;
    }

    public void setEmpJobTitle(String empJobTitle) {
        this.empJobTitle = empJobTitle;
    }

    public String getEmpCategory() {
        return empCategory;
    }

    public void setEmpCategory(String empCategory) {
        this.empCategory = empCategory;
    }

    public Long getAppPatientID() {
        return appPatientID;
    }

    public void setAppPatientID(Long appPatientID) {
        this.appPatientID = appPatientID;
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

    public Long getPatientNO() {
        return patientNO;
    }

    public void setPatientNO(Long patientNO) {
        this.patientNO = patientNO;
    }
}
