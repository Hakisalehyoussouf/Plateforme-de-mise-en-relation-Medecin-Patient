package ma.ensate.hospital.services;

import ma.ensate.hospital.entities.Consultation;
import ma.ensate.hospital.entities.Medecin;
import ma.ensate.hospital.entities.Patient;
import ma.ensate.hospital.entities.RendezVous;

public interface IHospitalService {

    //C'est pratique de retouner toujours les entites enregistrees avec la methode save()!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
