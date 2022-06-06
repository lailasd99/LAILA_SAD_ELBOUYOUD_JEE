package ma.enset.ebankingbackend.security.service;


import ma.enset.ebankingbackend.security.entities.AppRole;
import ma.enset.ebankingbackend.security.entities.AppUser;

public interface SecurityService {
    AppUser saveUser(String username, String password, String rePassword);
    AppRole addNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
}
