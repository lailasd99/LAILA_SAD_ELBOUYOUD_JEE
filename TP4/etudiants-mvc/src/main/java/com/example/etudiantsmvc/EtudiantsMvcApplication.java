package com.example.etudiantsmvc;

import com.example.etudiantsmvc.entities.etudiant;
import com.example.etudiantsmvc.entities.gender;
import com.example.etudiantsmvc.respositories.etudiantRespository;
import com.example.etudiantsmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class EtudiantsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantsMvcApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveUser("laila","1234","1234");
            securityService.saveUser("mohammed","1234","1234");
            securityService.saveUser("yassine","1234","1234");

            securityService.addNewRole("USER", "");
            securityService.addNewRole("ADMIN", "");

            securityService.addRoleToUser("laila", "USER");
            securityService.addRoleToUser("laila", "ADMIN");
            securityService.addRoleToUser("mohammed", "USER");
            securityService.addRoleToUser("yassine", "USER");
        };
    }

    @Bean
    CommandLineRunner commandLineRunner(etudiantRespository etudiantRepository){
        return args -> {
            etudiantRepository.save(new etudiant(null, "laila", "saad", "lailasd@gmail.com", new Date(), gender.FEMININ, true));
            etudiantRepository.save(new etudiant(null, "sarah", "alaoui", "alaoui@gmail.com", new Date(), gender.FEMININ, true));
            etudiantRepository.save(new etudiant(null, "imane", "amine", "imaneam@gmail.com", new Date(), gender.FEMININ, false));
            etudiantRepository.save(new etudiant(null, "ahmed", "ali", "ahmedali@gmail.com", new Date(), gender.MASCULIN, true));

            etudiantRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }

}
