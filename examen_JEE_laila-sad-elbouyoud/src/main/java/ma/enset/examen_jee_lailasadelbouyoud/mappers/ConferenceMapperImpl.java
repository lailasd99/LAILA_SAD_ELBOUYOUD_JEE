package ma.enset.examen_jee_lailasadelbouyoud.mappers;

import ma.enset.examen_jee_lailasadelbouyoud.DTOs.*;
import ma.enset.examen_jee_lailasadelbouyoud.entities.*;
import org.springframework.beans.BeanUtils;

public class ConferenceMapperImpl {

    public SessionDTO fromSession(Session session){
        SessionDTO sessionDTO = new SessionDTO();
        BeanUtils.copyProperties(session, sessionDTO);
        sessionDTO.setSalle(fromSalle(session.getSalle()));
        sessionDTO.setModerator(fromModerator(session.getModerator()));
        return sessionDTO;
    }

    public Session fromSessionDTO(SessionDTO sessionDTO){
        Session session = new Session();
        BeanUtils.copyProperties(sessionDTO, session);
        session.setSalle(fromSalleDTO(sessionDTO.getSalle()));
        session.setModerator(fromModeratorDTO(sessionDTO.getModerator()));
        return session;
    }

    public SalleDTO fromSalle(Salle salle){
        SalleDTO salleDTO = new SalleDTO();
        BeanUtils.copyProperties(salle, salleDTO);
        return salleDTO;
    }

    public Salle fromSalleDTO(SalleDTO salleDTO){
        Salle salle = new Salle();
        BeanUtils.copyProperties(salleDTO, salle);
        return salle;
    }

    public Moderator fromModeratorDTO(ModeratorDTO moderatorDTO){
        Moderator moderator = new Moderator();
        BeanUtils.copyProperties(moderatorDTO, moderator);
        return moderator;
    }

    public ModeratorDTO fromModerator(Moderator moderator){
        ModeratorDTO moderatorDTO = new ModeratorDTO();
        BeanUtils.copyProperties(moderator, moderatorDTO);
        return moderatorDTO;
    }

    public Conference fromConferenceDTO(ConferenceDTO conferenceDTO) {
        Conference conference = new Conference();
        BeanUtils.copyProperties(conferenceDTO, conference);
        conference.setSession(fromSessionDTO(conferenceDTO.getSession()));
        conference.setSpeaker(fromSpeakerDTO(conferenceDTO.getSpeaker()));
        return conference;
    }

    public ConferenceDTO fromConference(Conference conference) {
        ConferenceDTO conferenceDTO = new ConferenceDTO();
        BeanUtils.copyProperties(conference, conferenceDTO);
        conferenceDTO.setSession(fromSession(conference.getSession()));
        conferenceDTO.setSpeaker(fromSpeaker(conference.getSpeaker()));
        return conferenceDTO;
    }

    public Speaker fromSpeakerDTO(SpeakerDTO speakerDTO) {
        Speaker speaker = new Speaker();
        BeanUtils.copyProperties(speakerDTO, speaker);
        return speaker;
    }

    public SpeakerDTO fromSpeaker(Speaker speaker) {
        SpeakerDTO speakerDTO = new SpeakerDTO();
        BeanUtils.copyProperties(speaker, speakerDTO);
        return speakerDTO;
    }

    public Guest fromGuestDTO(GuestDTO guestDTO){
        Guest guest = new Guest();
        BeanUtils.copyProperties(guestDTO, guest);
        return guest;
    }

    public GuestDTO fromGuest(Guest guest){
        GuestDTO guestDTO = new GuestDTO();
        BeanUtils.copyProperties(guest, guestDTO);
        return guestDTO;
    }

    public InscriptionDTO fromInscription(Inscription inscription){
        InscriptionDTO inscriptionDTO = new InscriptionDTO();
        BeanUtils.copyProperties(inscription, inscriptionDTO);
        inscriptionDTO.setSession(fromSession(inscription.getSession()));
        return inscriptionDTO;
    }

    public Inscription fromInscriptionDTO(InscriptionDTO inscriptionDTO){
        Inscription inscription = new Inscription();
        BeanUtils.copyProperties(inscriptionDTO, inscription);
        inscription.setSession(fromSessionDTO(inscriptionDTO.getSession()));
        return inscription;
    }
}
