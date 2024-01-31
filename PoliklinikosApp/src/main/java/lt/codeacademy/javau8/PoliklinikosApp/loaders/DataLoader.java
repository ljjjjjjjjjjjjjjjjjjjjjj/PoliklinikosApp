package lt.codeacademy.javau8.PoliklinikosApp.loaders;



import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalProduct;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Appointment;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.AppointmentRepository;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.EmployeeRepository;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.MedicalProductRepository;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    MedicalProductRepository medicalProductRepository;

    @Autowired
    AppointmentRepository appointmentRepository;


    @Override
    public void run(String... args) throws Exception {

        if(employeeRepository.count() > 0){return;}


        // Employees
        Employee employee0 = new Employee("Rasa", "Jankauskiene", "Subaciaus.g 1-10, Vilniaus m.", "+370 620 57108", "rasa@outlook.com", "Direktore", "/imagesEmployees/Employee_profile.png");
        Employee employee1 = new Employee("Petras", "Petraitis", "Didzioji.g 1-11, Vilniaus m.", "+370 620 57108", "petras@gmail.com", "Ukvedys","/imagesEmployees/Employee_profile.png");
        Employee employee2 = new Employee("Alina","Jersova", "Vilniaus.g 1-11, Vilniaus m.","+370 612 34567", "alina@gmail.com", "Vyr. Slaugytoja", "/imagesEmployees/Employee_profile.png");
        Employee employee3 = new Employee("Viktorija", "Viktoriene", "Vilniaus.g 1-11, Vilniaus m.","+370 612 34567", "viktorija@gmail.com", "Slaugytoja" , "/imagesEmployees/Employee_profile.png");
        Employee employee4 = new Employee("Juste", "Justutyte", "Vilniaus.g 1-11, Vilniaus m.","+370 612 34567", "juste@gmail.com", "Seimos Gydytoja" , "/imagesEmployees/Employee_profile.png");
        Employee employee5 = new Employee("Olga", "Osokina", "Vilniaus.g 1-11, Vilniaus m.","+370 612 34567", "olga@gmail.com", "Seimos Gydytoja", "/imagesEmployees/Employee_profile.png");
        Employee employee6 = new Employee("Onute","Onutiene", "Vilniaus.g 1-11, Vilniaus m.","+370 612 34567", "ona@gmail.com", "Seimos Gydytoja", "/imagesEmployees/Employee_profile.png");
        Employee employee7 = new Employee("Justina", "Justauskaite", "Vilniaus.g 1-11, Vilniaus m.","+370 612 34567", "justina@gmail.com", "LOR", "/imagesEmployees/Employee_profile.png");
        Employee employee8 = new Employee("Jonas", "Jonaitis", "Vilniaus.g 1-11, Vilniaus m.","+370 612 34567", "jonas@gmail.com", "Traumatologas", "/imagesEmployees/Employee_profile.png");
        Employee employee9 = new Employee("Aiste", "Aistiene", "Vilniaus.g 1-11, Vilniaus m.","+370 612 34567", "aiste@gmail.com", "Dermatologe", "/imagesEmployees/Employee_profile.png");
        Employee employee10 = new Employee("Irena", "Ireniene", "Vilniaus.g 1-11, Vilniaus m.","+370 612 34567", "irena@gmail.com", "Neurologe", "/imagesEmployees/Employee_profile.png");
        Employee employee11 = new Employee("Gryte", "Grytaite", "Vilniaus.g 1-11, Vilniaus m.","+370 612 34567", "gryte@gmail.com", "Odontologe" , "/imagesEmployees/Employee_profile.png");



        // Patients
        Patient patient1 = new Patient("Petras", "Petraitis", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "petras1@yahoo.com", "I");
        Patient  patient2 = new Patient ("Onute", "Onutiene", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "onute@yahoo.com", "I");
        Patient  patient3 = new Patient ("Mantas", "Mantaitis", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "mantas@yahoo.com", "I");
        Patient  patient4 = new Patient ("Juste", "Justiene", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "juste@yahoo.com", "I");
        Patient  patient5 = new Patient ("Vytautas", "Vytautitis", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "vytautas@yahoo.com", "I");

        Patient  patient6 = new Patient ("Jolanta", "Jolantiene", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "jolanta@yahoo.com", "I");
        Patient  patient7 = new Patient ("Medas", "Medutis", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "medas@yahoo.com", "I");
        Patient  patient8 = new Patient ("Petras", "Petraitis", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "petras2@yahoo.com", "II");
        Patient  patient9 = new Patient ("Rytis", "Rytenas", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "rytis@yahoo.com", "I");
        Patient  patient10 = new Patient ("Jonas", "Jonaits", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "jonas@yahoo.com", "I");

        Patient  patient11 = new Patient ("Egle", "Eglaite", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "egle@yahoo.com", "I");
        Patient  patient12 = new Patient ("Aleksandra", "Aleksandraite", "Pavilnio.g 1-12, Vilniaus m.", "+370 612 34567", "aleksandra@yahoo.com", "I");


        // MedicalProducts
        MedicalProduct medicalProduct1 = new MedicalProduct("Seimos gydytojo konsultacija - gyvai",  "Konsultacija. Pirminis lygis", "Seimos medicina ir slauga");
        MedicalProduct medicalProduct2 = new MedicalProduct("Seimos gydytojo konsultacija - telefonu", "Konsultacija. Pirminis lygis", "Seimos medicina ir slauga");
        MedicalProduct medicalProduct3 = new MedicalProduct("LOR konsultacija", "Konsultacija. Antrinis lygis", "Gydytojai specialistai");
        MedicalProduct medicalProduct4 = new MedicalProduct("Traumatologo konsultacija", "Konsultacija. Antrinis lygis", "Gydytojai specialistai");
        MedicalProduct medicalProduct5 = new MedicalProduct("Dermatologo konsultacija", "Konsultacija. Antrinis lygis", "Gydytojai specialistai");
        MedicalProduct medicalProduct6 = new MedicalProduct("Neurologo konsultacija", "Konsultacija. Tretinis lygis", "Gydytojai specialistai");
        MedicalProduct medicalProduct7 = new MedicalProduct("Odontologo konsultacija", "Odontologija. Pirminis lygis", "Odontologija");
        MedicalProduct medicalProduct8 = new MedicalProduct("Odontologo konsultacija", "Odontologija. Antrinis lygis", "Odontologija");

        MedicalProduct medicalProduct9 = new MedicalProduct("Ekoskopija", "Kiti tyrimai", "Tyrimai");
        MedicalProduct medicalProduct10 = new MedicalProduct("Bendrinis kraujo tyrimas", "Laboratoriniai tyrimai", "Tyrimai");
        MedicalProduct medicalProduct11 = new MedicalProduct("Tikslinis kraujo tyrimas", "Laboratoriniai tyrimai", "Tyrimai");
        MedicalProduct medicalProduct12 = new MedicalProduct("Gripo testas", "Laboratoriniai tyrimai", "Tyrimai");

        MedicalProduct medicalProduct13 = new MedicalProduct("Stabliges skiepai", "Skiepai (nemokami)", "Skiepai");
        MedicalProduct medicalProduct14 = new MedicalProduct("Erkinio encefalito skiepai", "Skiepai (mokami)", "Skiepai");
        MedicalProduct medicalProduct15 = new MedicalProduct("COVID skiepai", "Skiepai (nemokami)", "Skiepai");

        MedicalProduct medicalProduct16 = new MedicalProduct("Skambuciu valdymas ir pacientu registracija", "Registratura","Registratura");
        MedicalProduct medicalProduct17 = new MedicalProduct("Administracija", "Administracija", "Administracija");



        // Appointments
        Appointment appointment1 = new Appointment("Gyvai", "Temperatura", "2024-01-26, 09:30");
        Appointment appointment2 = new Appointment("Gyvai", "Berimas", "2024-01-26, 09:30");
        Appointment appointment3 = new Appointment("Gyvai", "Alkunes skausmas", "2024-01-26, 09:30");
        Appointment appointment4 = new Appointment("Gyvai", "Profilaktika", "2024-01-26, 09:30");
        Appointment appointment5 = new Appointment("Telefonu", "Temperatura", "2024-01-26, 09:30");
        Appointment appointment6 = new Appointment("Telefonu", "Temperatura", "2024-01-26, 09:30");



        employeeRepository.saveAll(Arrays.asList(
                employee0, employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9, employee10, employee11));


        patientRepository.saveAll(Arrays.asList(
                patient1,
                patient2,
                patient3,
                patient4,
                patient5,
                patient6,
                patient7,
                patient8,
                patient9,
                patient10,
                patient11,
                patient12
        ));

        medicalProductRepository.saveAll(Arrays.asList(
                medicalProduct1,
                medicalProduct2,
                medicalProduct3,
                medicalProduct4,
                medicalProduct5,
                medicalProduct6,
                medicalProduct7,
                medicalProduct8,
                medicalProduct9,
                medicalProduct10,
                medicalProduct11,
                medicalProduct12,
                medicalProduct13,
                medicalProduct14,
                medicalProduct15,
                medicalProduct16,
                medicalProduct17
        ));

        appointmentRepository.saveAll(Arrays.asList(
                appointment1,
                appointment2,
                appointment3,
                appointment4,
                appointment5,
                appointment6
        ));






        // Employees' Lists & Objects
        // a) Employees' Lists & Objects - Medical Products
        employee0.addMedicalProducts(medicalProduct17);

        // Slaugytojos
        employee2.addMedicalProducts(medicalProduct10);  // vyr
        employee2.addMedicalProducts(medicalProduct11);
        employee2.addMedicalProducts(medicalProduct12);
        employee2.addMedicalProducts(medicalProduct13);
        employee2.addMedicalProducts(medicalProduct14);
        employee2.addMedicalProducts(medicalProduct15);
        employee2.addMedicalProducts(medicalProduct16);
        employee2.addMedicalProducts(medicalProduct17);

        employee3.addMedicalProducts(medicalProduct10); // n
        employee3.addMedicalProducts(medicalProduct11);
        employee3.addMedicalProducts(medicalProduct12);
        employee2.addMedicalProducts(medicalProduct13);
        employee2.addMedicalProducts(medicalProduct14);
        employee2.addMedicalProducts(medicalProduct15);
        employee2.addMedicalProducts(medicalProduct16);


        // Seimos
        employee4.addMedicalProducts(medicalProduct1);
        employee4.addMedicalProducts(medicalProduct2);

        employee5.addMedicalProducts(medicalProduct1);
        employee5.addMedicalProducts(medicalProduct2);

        employee6.addMedicalProducts(medicalProduct1);
        employee6.addMedicalProducts(medicalProduct2);

        // Specialistai
        employee7.addMedicalProducts(medicalProduct3); // LOR

        employee8.addMedicalProducts(medicalProduct4); // Traum

        employee9.addMedicalProducts(medicalProduct5); // Derma

        employee10.addMedicalProducts(medicalProduct6); //Neuro

        employee11.addMedicalProducts(medicalProduct7); // Odont
        employee11.addMedicalProducts(medicalProduct8);


        // Appointments' Lists & Objects
        // a) Appointments' Lists & Objects - Employees
        appointment1.setAppEmployee(employee4);
        appointment2.setAppEmployee(employee9);
        appointment3.setAppEmployee(employee10);
        appointment4.setAppEmployee(employee11);
        appointment5.setAppEmployee(employee5);
        appointment6.setAppEmployee(employee6);

        // b) Appointments' Lists & Objects - Patients
        appointment1.setAppPatient(patient1);
        appointment2.setAppPatient(patient2);
        appointment3.setAppPatient(patient3);
        appointment4.setAppPatient(patient4);
        appointment5.setAppPatient(patient5);
        appointment6.setAppPatient(patient6);







        // Save:


        employeeRepository.saveAll(Arrays.asList(
                employee0, employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9, employee10, employee11));


        patientRepository.saveAll(Arrays.asList(
                patient1,
                patient2,
                patient3,
                patient4,
                patient5,
                patient6,
                patient7,
                patient8,
                patient9,
                patient10,
                patient11,
                patient12
        ));

        medicalProductRepository.saveAll(Arrays.asList(
                medicalProduct1,
                medicalProduct2,
                medicalProduct3,
                medicalProduct4,
                medicalProduct5,
                medicalProduct6,
                medicalProduct7,
                medicalProduct8,
                medicalProduct9,
                medicalProduct10,
                medicalProduct11,
                medicalProduct12,
                medicalProduct13,
                medicalProduct14,
                medicalProduct15,
                medicalProduct16,
                medicalProduct17
        ));


        appointmentRepository.saveAll(Arrays.asList(
                appointment1,
                appointment2,
                appointment3,
                appointment4,
                appointment5,
                appointment6
        ));


        // Remove:













    }
}


  /*

        employeeRepository.saveAll(Arrays.asList(
                                   employee1,
                                   employee2,
                                   employee3,
                                   employee4,
                                   employee5,
                                   employee6,
                                   employee7,
                                   employee8,
                                   employee9,
                                   employee10,
                                   employee11));

        patientRepository.saveAll(Arrays.asList(
                                  patient1,
                                  patient2,
                                  patient3,
                                  patient4,
                                  patient5,
                                  patient6,
                                  patient7,
                                  patient8,
                                  patient9,
                                  patient10,
                                  patient11,
                                  patient12
                                  ));


        appointmentRepository.saveAll(Arrays.asList(
                                      appointment1,
                                      appointment2,
                                      appointment3,
                                      appointment4,
                                      appointment5,
                                      appointment6
                                      ));


       medicalProductRepository.saveAll(Arrays.asList(
                medicalProduct1,
                medicalProduct2,
                medicalProduct3,
                medicalProduct4,
                medicalProduct5,
                medicalProduct6,
                medicalProduct7,
                medicalProduct8,
                medicalProduct9,
                medicalProduct10,
                medicalProduct11
        ));

*/