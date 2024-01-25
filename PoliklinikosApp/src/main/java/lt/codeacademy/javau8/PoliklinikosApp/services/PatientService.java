package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PatientService {

    public List<Patient> getPatientsDummy() {
        List<Patient> patientDummyList = new ArrayList<>();
        Patient patient1 = new Patient("Vardenis1", "Pavardenis1");
        Patient patient2 = new Patient("Vardenis2", "Pavardenis2");

        patientDummyList.add(patient1);
        patientDummyList.add(patient2);

        return patientDummyList;
    }


}
