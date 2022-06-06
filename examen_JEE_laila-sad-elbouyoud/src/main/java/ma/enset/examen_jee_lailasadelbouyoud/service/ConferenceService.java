package ma.enset.examen_jee_lailasadelbouyoud.service;

import ma.enset.examen_jee_lailasadelbouyoud.DTOs.*;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Conference;

import java.util.List;

public interface ConferenceService {
    ConferenceDTO saveConference(ConferenceDTO conferenceDTO);
    SpeakerDTO saveSpeaker(SpeakerDTO speakerDTO);
    ModeratorDTO saveModerator(ModeratorDTO moderatorDTO);
    GuestDTO saveGuest(GuestDTO guestDTO);
    SessionDTO saveSession(SessionDTO sessionDTO);

    List<ConferenceDTO> getConferences(Long sessionId);
    List<SessionDTO> getSessions();

    List<InscriptionDTO> getInscriptions(Long id);
}
