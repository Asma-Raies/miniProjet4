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




public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);


}