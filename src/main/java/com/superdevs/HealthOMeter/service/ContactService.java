package com.superdevs.HealthOMeter.service;

import com.superdevs.HealthOMeter.entity.Contact;
import com.superdevs.HealthOMeter.repositories.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactService.class);

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        logger.info("Started getAllContacts in ContactService");

        return contactRepository.findAll();
    }

    public Contact findContactById(Long contactId) {
        logger.info("Started findContactById in ContactService");

        return contactRepository.findById(contactId).orElseThrow();
    }

    public Contact createContact(Contact contact) {
        logger.info("Started createContact in ContactService");

        Optional<Contact> contactOptional = contactRepository.findById(contact.getId());
        if (!contactOptional.isPresent()) {
            return contactRepository.save(contact);
        }
        return contact;
    }

    public Contact updateContact(Contact contact) {
        logger.info("Started updateContact in ContactService");

        Optional<Contact> contactOptional = contactRepository.findById(contact.getId());
        if (!contactOptional.isPresent()) {
            return contactRepository.save(contact);
        }
        return contact;
    }

    public void deleteContact(Long id) {
        logger.info("Started deleteContact in ContactService");

        Contact deleteContact = contactRepository.findById(id).orElseThrow();
        contactRepository.delete(deleteContact);
    }
}
