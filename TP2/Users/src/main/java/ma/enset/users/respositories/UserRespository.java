package ma.enset.users.respositories;

import ma.enset.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
