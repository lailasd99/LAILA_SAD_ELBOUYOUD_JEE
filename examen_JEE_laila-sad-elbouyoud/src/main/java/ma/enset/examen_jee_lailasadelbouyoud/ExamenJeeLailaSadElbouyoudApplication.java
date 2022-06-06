package ma.enset.examen_jee_lailasadelbouyoud;

import ma.enset.examen_jee_lailasadelbouyoud.entities.Guest;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Moderator;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Participant;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Speaker;
import ma.enset.examen_jee_lailasadelbouyoud.enums.Gender;
import ma.enset.examen_jee_lailasadelbouyoud.repositories.GuestRepository;
import ma.enset.examen_jee_lailasadelbouyoud.repositories.ModeratorRepository;
import ma.enset.examen_jee_lailasadelbouyoud.repositories.ParticipantRepository;
import ma.enset.examen_jee_lailasadelbouyoud.repositories.SpeakerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ExamenJeeLailaSadElbouyoudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenJeeLailaSadElbouyoudApplication.class, args);
    }


    
    @Bean
    CommandLineRunner commandLineRunner(ModeratorRepository moderatorRepository,
                                        GuestRepository guestRepository,
                                        SpeakerRepository speakerRepository){
        return args -> {
            Stream.of("laila", "ilham", "aicha").forEach(name->{
                Speaker speaker = new Speaker();
                speaker.setName(name);
                speaker.setEmail(name + "@gmail.com");
                speaker.setPhoto("photo"+Math.random()*12000);
                speaker.setGender(Gender.FEMININ);
                speaker.setLink("link"+Math.random()*12056);
                speakerRepository.save(speaker);
            });
            Stream.of("ali", "mohammed", "anas").forEach(name->{
                Moderator moderator = new Moderator();
                moderator.setName(name);
                moderator.setEmail(name + "@gmail.com");
                moderator.setPhoto("photo"+Math.random()*12000);
                moderator.setGender(Gender.MASCULIN);
                moderator.setSpeciality("Speciality1");
                moderatorRepository.save(moderator);
            });
            Stream.of("oumaima", "asmaa", "khadija").forEach(name->{
                Guest guest = new Guest();
                guest.setName(name);
                guest.setEmail(name + "@gmail.com");
                guest.setPhoto("photo"+Math.random()*12000);
                guest.setGender(Gender.FEMININ);
                guest.setAffiliation("link"+Math.random()*12056);
                guestRepository.save(guest);
            });
        };
    }

}
