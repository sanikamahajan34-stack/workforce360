package com.workforce360.repository;

import com.workforce360.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission,Long> {

    Optional<Permission> findByName(String name);

    boolean existsByName(String name);

}
