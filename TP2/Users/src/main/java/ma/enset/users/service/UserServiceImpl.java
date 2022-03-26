package ma.enset.users.service;

import lombok.AllArgsConstructor;
import ma.enset.users.entities.Role;
import ma.enset.users.entities.User;
import ma.enset.users.respositories.RoleRespository;
import ma.enset.users.respositories.UserRespository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private RoleRespository roleRespository;
    private UserRespository userRespository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRespository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRespository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRespository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRespository.findByRoleName(roleName);
    }

    @Override
    public Role addRoleToUser(String username, String rolename) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(rolename);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        return null;
    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRespository.findByUsername(username);
        if(user==null) throw new RuntimeException("Bad Credentials!");
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad Credentials!");
    }
}
