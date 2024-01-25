package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalServiceService {

    public List<MedicalService> getMedicalServicesDummy() {
        List<MedicalService> medicalServicesDummyList = new ArrayList<>();
        MedicalService tyrimai1 = new MedicalService( "Kraujo tyrimai", "Tyrimai");
        MedicalService konsultacija1 = new MedicalService("Pirmine apziura", "Konsultacijos");

        medicalServicesDummyList.add(tyrimai1);
        medicalServicesDummyList.add(konsultacija1);

        return medicalServicesDummyList;
    }
}
