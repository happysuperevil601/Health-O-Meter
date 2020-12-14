package com.superdevs.HealthOMeter.controllers;

import com.superdevs.HealthOMeter.dto.ContactDto;
import com.superdevs.HealthOMeter.mappers.ContactMapper;
import com.superdevs.HealthOMeter.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/hom")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactMapper contactMapper;

    @GetMapping(value = "/contacts")
    public ResponseEntity<?> getAllContacts() {
        logger.warn("Getting all contacts!");

        return ResponseEntity.ok(contactMapper.mapToContactDtoList(contactService.getAllContacts()));
    }

    @DeleteMapping(value = "/contact/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") Long id) {
        logger.warn("Deleting a contact!");
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/contact", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createContact(@RequestBody ContactDto contactDto) {
        logger.info("Creating contact!");
        contactService.createContact(contactMapper.mapToContact(contactDto));
    }
}
