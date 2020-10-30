package com.superdevs.HealthOMeter.repository;

import com.superdevs.HealthOMeter.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Long> {
    Optional<Authority> findByAuthority(String authorityName);
}
