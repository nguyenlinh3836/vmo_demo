package com.example.vmo_demo.repository;

import com.example.vmo_demo.common.enums.ERole;
import com.example.vmo_demo.model.entities.Role;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(ERole name);
}
