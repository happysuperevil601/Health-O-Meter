package com.superdevs.HealthOMeter.controllers;

import com.superdevs.HealthOMeter.dto.ContactDto;
import com.superdevs.HealthOMeter.mappers.ContactMapper;
import com.superdevs.HealthOMeter.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

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
        logger.info("Started getAllContacts ContactController!");
        try {
            logger.info("Success getAllContacts ContactController!");
            return ResponseEntity.ok(contactMapper.mapToContactDtoList(contactService.getAllContacts()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllContacts ContactController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid" + e);
        }
    }

    @DeleteMapping(value = "/contact/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") Long id) {
        logger.info("Started deleteContact ContactController!");
        try {
            contactService.deleteContact(id);
            logger.info("Success deleteContact ContactController!");
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed deleteContact ContactController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PostMapping(value = "/contact")
    public ResponseEntity<?> createContact(@RequestBody ContactDto contactDto) {
        logger.info("Started createContact ContactController!");
        try {
            return ResponseEntity.ok(contactService.createContact(contactMapper.mapToContact(contactDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createContact ContactController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @GetMapping(value = "/contact/{id}")
    public ResponseEntity<?> getContact(@PathVariable("id") Long id) {
        logger.info("Started getContact ContactController!");
        try {
            logger.info("Success getContact ContactController!");
            return ResponseEntity.ok(contactService.findContactById(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getContact ContactController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PutMapping(value = "/contact/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateContact(@RequestBody ContactDto contactDto) {
        logger.info("Started updateContact ContactController!");
        try {
            logger.info("Success updateContact ContactController!");
            return ResponseEntity.ok(contactService.updateContact(contactMapper.mapToContact(contactDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed updateContact ContactController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

}
