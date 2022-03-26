package ma.enset.hospital.respositories;

import ma.enset.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRespository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);
}
