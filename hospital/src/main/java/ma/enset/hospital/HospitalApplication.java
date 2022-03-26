package ma.enset.hospital;

import ma.enset.hospital.entities.*;
import ma.enset.hospital.respositories.ConsultationRespository;
import ma.enset.hospital.respositories.MedecinRespository;
import ma.enset.hospital.respositories.PatientRespository;
import ma.enset.hospital.respositories.RendezVousRespository;
import ma.enset.hospital.service.IhospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {

		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IhospitalService service,
							PatientRespository patientRespository,
							MedecinRespository medecinRespository,
							RendezVousRespository rendezVousRespository){
		return args -> {
			Stream.of("mohammed", "hassan", "najat")
							.forEach(name->{
								Patient patient = new Patient();
								patient.setNom(name);
								patient.setDateNaissance(new Date());
								patient.setMalade(false);
								service.savePatient(patient);
							});

			Stream.of("aymane", "hanane", "yasmine")
					.forEach(name->{
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name + "@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						service.saveMedecin(medecin);
					});

			Patient patient = patientRespository.findById(1L).orElse(null);
			Medecin medecin = medecinRespository.findByNom("yasmine");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			service.saveRV(rendezVous);


			RendezVous rdv = rendezVousRespository.findById(1L).orElse(null);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rdv);
			consultation.setRapport("rapport de la consultation.");
			service.saveConcultation(consultation);
		};
	}

}
