package ma.enset.examen_jee_lailasadelbouyoud.web;

import ma.enset.examen_jee_lailasadelbouyoud.DTOs.ConferenceDTO;
import ma.enset.examen_jee_lailasadelbouyoud.DTOs.InscriptionDTO;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Inscription;
import ma.enset.examen_jee_lailasadelbouyoud.service.ConferenceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class InscriptionRestController {
    private ConferenceService conferenceService;

    @GetMapping("/inscriptions?id={id}")
    public List<InscriptionDTO> inscriptions(@PathVariable Long id){
        return conferenceService.getInscriptions(id);
    }
}
