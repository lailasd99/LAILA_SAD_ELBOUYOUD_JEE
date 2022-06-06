package ma.enset.examen_jee_lailasadelbouyoud.service;

import ma.enset.examen_jee_lailasadelbouyoud.DTOs.*;
import ma.enset.examen_jee_lailasadelbouyoud.entities.*;
import ma.enset.examen_jee_lailasadelbouyoud.mappers.ConferenceMapperImpl;
import ma.enset.examen_jee_lailasadelbouyoud.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ConferenceServiceImpl implements ConferenceService{
    @Autowired
    private ConferenceMapperImpl mapper;
    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private SpeakerRepository speakerRepository;
    @Autowired
    private ModeratorRepository moderatorRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public ConferenceDTO saveConference(ConferenceDTO conferenceDTO) {
        Conference conference = mapper.fromConferenceDTO(conferenceDTO);
        Conference saved = conferenceRepository.save(conference);
        return mapper.fromConference(saved);
    }

    @Override
    public SpeakerDTO saveSpeaker(SpeakerDTO speakerDTO) {
        Speaker speaker = mapper.fromSpeakerDTO(speakerDTO);
        Speaker saved = speakerRepository.save(speaker);
        return mapper.fromSpeaker(saved);
    }

    @Override
    public ModeratorDTO saveModerator(ModeratorDTO moderatorDTO) {
        Moderator moderator = mapper.fromModeratorDTO(moderatorDTO);
        Moderator saved = moderatorRepository.save(moderator);
        return mapper.fromModerator(saved);
    }

    @Override
    public GuestDTO saveGuest(GuestDTO guestDTO) {
        Guest guest = mapper.fromGuestDTO(guestDTO);
        Guest saved = guestRepository.save(guest);
        return mapper.fromGuest(saved);
    }

    @Override
    public SessionDTO saveSession(SessionDTO sessionDTO) {
        Session session = mapper.fromSessionDTO(sessionDTO);
        Session saved = sessionRepository.save(session);
        return mapper.fromSession(saved);
    }

    @Override
    public List<ConferenceDTO> getConferences(Long sessionDId) {
        Session session = sessionRepository.findById(sessionDId).orElse(null);
        List<Conference> conferences = conferenceRepository.findBySession(session);
        List<ConferenceDTO> conferenceDTO = conferences.stream().map(conference -> {
            return mapper.fromConference(conference);
        }).collect(Collectors.toList());
        return conferenceDTO;

    }

    @Override
    public List<SessionDTO> getSessions() {
        List<Session> sessions = sessionRepository.findAll();
        List<SessionDTO> sessionsDTO = sessions.stream().map(session -> {
            return mapper.fromSession(session);

        }).collect(Collectors.toList());
        return sessionsDTO;
    }

    @Override
    public List<InscriptionDTO> getInscriptions(Long id) {
        return null;
    }
}
