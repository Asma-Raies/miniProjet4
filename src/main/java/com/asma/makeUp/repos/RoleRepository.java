package com.asma.makeUp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asma.makeUp.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRole(String role);
	
}