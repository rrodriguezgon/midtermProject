/**
 *
 */
package com.ironhack.midtermProject.repository.security;

import com.ironhack.midtermProject.model.security.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Integer> {
    /**
     * This method search user whose name attribute matches with param
     * @param username a String value
     * @return A user whose username attribute matches with username param
     */
    ThirdParty findByUsername(String username);
}
