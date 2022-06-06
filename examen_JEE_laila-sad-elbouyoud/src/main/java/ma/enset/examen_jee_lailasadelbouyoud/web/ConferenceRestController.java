package ma.enset.examen_jee_lailasadelbouyoud.web;

import ma.enset.examen_jee_lailasadelbouyoud.DTOs.ConferenceDTO;
import ma.enset.examen_jee_lailasadelbouyoud.DTOs.SessionDTO;
import ma.enset.examen_jee_lailasadelbouyoud.repositories.ConferenceRepository;
import ma.enset.examen_jee_lailasadelbouyoud.repositories.SessionRepository;
import ma.enset.examen_jee_lailasadelbouyoud.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ConferenceRestController {
    private ConferenceService conferenceService;


    @GetMapping("/sessions")
    public List<SessionDTO> sessions(){
        return conferenceService.getSessions();
    }

    @GetMapping("/sessions/{id}/conferences")
    public List<ConferenceDTO> conferences(@PathVariable Long id){
        return conferenceService.getConferences(id);
    }



}
