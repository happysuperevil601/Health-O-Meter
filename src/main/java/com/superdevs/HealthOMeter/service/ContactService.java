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

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    public Contact createContact(Contact contact){
        Optional<Contact> contactOptional = contactRepository.findById(contact.getId());
        if (!contactOptional.isPresent()){
            return contactRepository.save(contact);
        }
        return contact;
    }

    public Contact updateContact(Contact contact){
        Optional<Contact> contactOptional = contactRepository.findById(contact.getId());
        if (!contactOptional.isPresent()){
            return contactRepository.save(contact);
        }
        return contact;
    }

    public void deleteContact(Long id){
        Contact deleteContact = contactRepository.findById(id).orElseThrow();
        contactRepository.delete(deleteContact);
    }
}
