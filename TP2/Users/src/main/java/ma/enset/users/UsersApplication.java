package ma.enset.users;

import ma.enset.users.entities.Role;
import ma.enset.users.entities.User;
import ma.enset.users.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UsersApplication {

    public static void main(String[] args) {SpringApplication.run(UsersApplication.class, args);}

    @Bean
    CommandLineRunner start(IUserService service) {
        return args -> {
            User u = new User();
            u.setUsername("user1");
            u.setPassword("12345");
            service.addNewUser(u);

            User u2 = new User();
            u2.setUsername("admin");
            u2.setPassword("12345");
            service.addNewUser(u2);

            Stream.of("STUDENT", "USER", "ADMIN").forEach(r->{
                Role role = new Role();
                role.setRoleName(r);
                service.addNewRole(role);
            });

            service.addRoleToUser("user1", "USER");
            service.addRoleToUser("user1", "STUDENT");
            service.addRoleToUser("admin", "USER");
            service.addRoleToUser("admin", "ADMIN");

            try{
                User user = service.authenticate("user1", "12345");
                System.out.println(user.getUserId());
                System.out.println(user.getUsername());
                System.out.println("Roles : ");
                user.getRoles().forEach(r->{
                    System.out.println("Role : "+ r.toString());
                });
            }catch(Exception e){
                e.printStackTrace();
            }
        };
    }

}
