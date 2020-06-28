/**
 *
 */
package com.ironhack.midtermProject.repository;

import com.ironhack.midtermProject.model.entities.CreditCardAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface CreditCardAccountRepository extends JpaRepository<CreditCardAccount, Integer> {
}
