package com.example.vmo_demo.repository;

import com.example.vmo_demo.model.entities.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
  Optional<Account> findByUserName(String username);
  Boolean existsByUserName(String username);
}
