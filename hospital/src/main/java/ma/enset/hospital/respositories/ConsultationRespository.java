package ma.enset.hospital.respositories;

import ma.enset.hospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRespository extends JpaRepository<Consultation, Long> {
}
