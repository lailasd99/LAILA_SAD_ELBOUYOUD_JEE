package ma.enset.hospital.respositories;

import ma.enset.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRespository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name);

}
