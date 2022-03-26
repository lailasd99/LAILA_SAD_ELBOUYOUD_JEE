package ma.enset.hospital.service;

import lombok.AllArgsConstructor;
import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.respositories.ConsultationRespository;
import ma.enset.hospital.respositories.MedecinRespository;
import ma.enset.hospital.respositories.PatientRespository;
import ma.enset.hospital.respositories.RendezVousRespository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class hospitalServiceImpl implements IhospitalService {
    PatientRespository patientRespository;
    MedecinRespository medecinRespository;
    RendezVousRespository rendezVousRespository;
    ConsultationRespository consultationRespository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRespository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRespository.save(medecin);
    }

    @Override
    public RendezVous saveRV(RendezVous rendezVous) {
        return rendezVousRespository.save(rendezVous);
    }

    @Override
    public Consultation saveConcultation(Consultation consultation) {
        return consultationRespository.save(consultation);
    }
}
