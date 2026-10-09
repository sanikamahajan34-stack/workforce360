package com.workforce360.repository;

import com.workforce360.entity.LeavePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeavePolicyRepository extends JpaRepository<LeavePolicy, Long> {

    Optional<LeavePolicy> findByName(String name);

    List<LeavePolicy> findByActiveTrue();

    boolean existsByName(String name);
}