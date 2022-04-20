package ma.enset.patientsmvc;

import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepository;
import ma.enset.patientsmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "Hassan", new Date(),false, 120));
            patientRepository.save(new Patient(null, "Mohammed", new Date(),true, 122));
            patientRepository.save(new Patient(null, "Laila", new Date(),true, 342));
            patientRepository.save(new Patient(null, "Asmaa", new Date(),false, 123));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }

    //@Bean
    CommandLineRunner saveUser(SecurityService securityService){
        return args -> {
            securityService.saveUser("laila","1234","1234");
            securityService.saveUser("ilham","1234","1234");
            securityService.saveUser("hafsa","1234","1234");

            securityService.addNewRole("USER", "");
            securityService.addNewRole("ADMIN", "");

            securityService.addRoleToUser("laila", "USER");
            securityService.addRoleToUser("laila", "ADMIN");
            securityService.addRoleToUser("ilham", "USER");
            securityService.addRoleToUser("hafsa", "USER");
        };
    }


}
