package com.ironhack.midtermProject.repository;

import com.ironhack.midtermProject.model.entities.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount,Integer> {
}
