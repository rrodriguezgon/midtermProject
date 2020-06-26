/**
 *
 */
package com.ironhack.midtermProject.repository;

import com.ironhack.midtermProject.model.entities.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount,Integer> {
}
