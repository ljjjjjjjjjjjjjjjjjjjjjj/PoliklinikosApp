
package lt.codeacademy.javau8.PoliklinikosApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long recordID;
    String recordCategory;
    String recordDate;
    // LocalDateTime recordDate;
    String recordContent;


    // Constructors:

    public MedicalRecord() {}

    public MedicalRecord(Long recordID) {
        this.recordID = recordID;
    }

    public MedicalRecord(Long recordID, String recordCategory) {
        this.recordID = recordID;
        this.recordCategory = recordCategory;
    }

    public MedicalRecord(String recordCategory, String recordDate, String recordContent) {
        this.recordCategory = recordCategory;
        this.recordDate = recordDate;
        this.recordContent = recordContent;
    }

    public MedicalRecord(Long recordID, String recordCategory, String recordDate, String recordContent) {
        this.recordID = recordID;
        this.recordCategory = recordCategory;
        this.recordDate = recordDate;
        this.recordContent = recordContent;
    }

    // Getters & Setters

    public Long getRecordID() {
        return recordID;}
    public void setRecordID(Long recordID) {
        this.recordID = recordID;}

    public String getRecordCategory() {
        return recordCategory;}
    public void setRecordCategory(String recordCategory) {
        this.recordCategory = recordCategory;}

    public String getRecordDate() {
        return recordDate;}
    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;}

    public String getRecordContent() {
        return recordContent;}
    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;}




    // Methods:






}
