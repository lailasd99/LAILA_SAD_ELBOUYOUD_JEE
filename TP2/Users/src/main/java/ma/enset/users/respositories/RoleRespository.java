package ma.enset.users.respositories;

import ma.enset.users.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRespository extends JpaRepository<Role, Long> {
    Role findByRoleName(String rolename);
}
