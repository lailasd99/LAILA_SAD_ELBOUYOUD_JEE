package ma.enset.hospital.web;

import lombok.AllArgsConstructor;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.respositories.PatientRespository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PatientRestController {
    private PatientRespository patientRespository;

    @GetMapping("/patients")
    public List<Patient> patientList(){
        return patientRespository.findAll();
    }
}
