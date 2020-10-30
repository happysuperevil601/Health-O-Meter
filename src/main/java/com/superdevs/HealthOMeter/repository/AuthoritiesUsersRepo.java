package com.superdevs.HealthOMeter.repository;

import com.superdevs.HealthOMeter.entity.Authorities_Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesUsersRepo extends JpaRepository<Authorities_Users, Long> {
}
