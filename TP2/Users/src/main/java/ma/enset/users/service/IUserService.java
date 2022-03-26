package ma.enset.users.service;

import ma.enset.users.entities.Role;
import ma.enset.users.entities.User;

public interface IUserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String roleName);
    Role addRoleToUser(String username, String rolename);
    User authenticate(String username, String password);
}
