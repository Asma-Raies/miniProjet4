package com.asma.makeUp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asma.makeUp.entities.Role;
import com.asma.makeUp.entities.User;
import com.asma.makeUp.repos.RoleRepository;
import com.asma.makeUp.repos.UserRepository;
import com.asma.makeUp.roleType.RoleType;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    @Transactional
    public void save(User user) {


        var userRole = roleRepository.findByRole(RoleType.ROLE_ADMIN.name())
                .orElse(
                
                        Role.builder()
                                .role(RoleType.ROLE_ADMIN.name())
                                .build()
                );
       
        if (userRole.getUsers() == null) {
            userRole = roleRepository.save(userRole);
        }
        var defaultUserRole = List.of(userRole);
        user.setRoles(defaultUserRole);
        var savedUser = userRepository.save(user);
        savedUser.setPassword(encoder.encode(savedUser.getPassword()));
        userRole.setUsers(new ArrayList<>(List.of(savedUser)));
        roleRepository.save(userRole);

    }

}