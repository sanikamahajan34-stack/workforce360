package com.workforce360.repository;

import com.workforce360.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRole(String name);

    boolean existsByName(String name);

}
