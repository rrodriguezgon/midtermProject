/**
 *
 */
package com.ironhack.midtermProject.repository.security;

import com.ironhack.midtermProject.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
