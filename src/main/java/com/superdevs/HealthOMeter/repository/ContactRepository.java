package com.superdevs.HealthOMeter.repository;

import com.superdevs.HealthOMeter.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
