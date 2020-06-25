package com.ironhack.midtermProject.repository.security;

import com.ironhack.midtermProject.model.security.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    /**
     * This method search user whose name attribute matches with param
     * @param username a String value
     * @return A user whose username attribute matches with username param
     */
    Admin findByUsername(String username);
}
