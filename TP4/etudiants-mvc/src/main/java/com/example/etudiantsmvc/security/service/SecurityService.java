package com.example.etudiantsmvc.security.service;

import com.example.etudiantsmvc.security.entities.AppRole;
import com.example.etudiantsmvc.security.entities.AppUser;

public interface SecurityService {
    AppUser saveUser(String username, String password, String rePassword);
    AppRole addNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
}
