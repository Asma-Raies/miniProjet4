package com.asma.makeUp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asma.makeUp.entities.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByRole (String roleName);
}
