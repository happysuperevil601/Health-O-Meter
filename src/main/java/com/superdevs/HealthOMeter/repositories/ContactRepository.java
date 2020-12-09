package com.superdevs.HealthOMeter.repositories;

import com.superdevs.HealthOMeter.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Override
    List<Contact> findAll();

    @Override
    Optional<Contact> findById(Long id);

    Optional<Contact> findContactByFirstName(String firstName);

    Optional<Contact> findContactByLastName(String lastName);

    List<Contact> findContactByGender(Enum gender);

    List<Contact> findContactByCity(String city);

    List<Contact> findContactByCountry(String country);

    @Override
    void deleteById(Long id);
}
