package ma.ensate.hospital.repositories;

import ma.ensate.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name); // nous avons suppose que le nom est unique
}
