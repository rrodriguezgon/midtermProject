package com.ironhack.midtermProject.repository.security;

import com.ironhack.midtermProject.model.security.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {
    /**
     * This method search user whose name attribute matches with param
     * @param username a String value
     * @return A user whose username attribute matches with username param
     */
    AccountHolder findByUsername(String username);
}
