package ma.ensate.hospital;

import ma.ensate.hospital.entities.*;
import ma.ensate.hospital.repositories.ConsultationRepository;
import ma.ensate.hospital.repositories.MedecinRepository;
import ma.ensate.hospital.repositories.PatientRepository;
import ma.ensate.hospital.repositories.RendezVousRepository;
import ma.ensate.hospital.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {

	public static void main(String[] args) {

		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(IHospitalService iHospitalService,
							PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository){
		return args -> {
			//patientRepository.save(new Patient(null,"Haki",new Date(),false,null));
			Stream.of("Abizar","Salim","Ali")
					.forEach(name->{
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						iHospitalService.savePatient(patient);
					});
			Stream.of("Appo","Ali","Abdelhamid")
					.forEach(name->{
						Medecin medecin = new Medecin();
						medecin.setEmail(name+"@gmail.com");
						medecin.setNom(name);
						medecin.setSpecialite(Math.random()>0.5? "Cardio":"Dentiste");
						iHospitalService.saveMedecin(medecin);
					});

			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient1 = patientRepository.findByNom("Haki");

			Medecin medecin = medecinRepository.findByNom("Ali");


			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			rendezVousRepository.save(rendezVous);

			RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);

			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Le rapport de consultation");

			iHospitalService.saveConsultation(consultation);

		};
	}

}
