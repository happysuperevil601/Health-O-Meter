package com.superdevs.HealthOMeter.controllers;

import com.superdevs.HealthOMeter.dto.MedicalDataDto;
import com.superdevs.HealthOMeter.mappers.MedicalDataMapper;
import com.superdevs.HealthOMeter.service.MedicalDataService;
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
public class MedicalDataController {
    private static final Logger logger = LoggerFactory.getLogger(MedicalDataController.class);

    @Autowired
    private MedicalDataService medicalDataService;

    @Autowired
    private MedicalDataMapper medicalDataMapper;

    @GetMapping(value = "/medicalDatas")
    public ResponseEntity<?> getAllMedicalData() {
        logger.info("Started getAllMedicalData MedicalDataController!");
        try {
            logger.info("Success getAllMedicalData MedicalDataController!");
            return ResponseEntity.ok(medicalDataMapper.mapToMedicalDataDtoList(medicalDataService.getAllMedicalData()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllMedicalData MedicalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid" + e);
        }
    }

    @DeleteMapping(value = "/medicalData/{id}")
    public ResponseEntity<?> deleteMedicalData(@PathVariable("id") Long id) {
        logger.info("Started deleteMedicalData MedicalDataController!");
        try {
            medicalDataService.deleteMedicalData(id);
            logger.info("Success deleteMedicalData MedicalDataController!");
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed deleteMedicalData MedicalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PostMapping(value = "/medicalData")
    public ResponseEntity<?> createMedicalData(@RequestBody MedicalDataDto medicalDataDto) {
        logger.info("Started createMedicalData MedicalDataController!");
        try {
            return ResponseEntity.ok(medicalDataService.createMedicalData(medicalDataMapper.mapToMedicalData(medicalDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createMedicalData MedicalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @GetMapping(value = "/medicalData/{id}")
    public ResponseEntity<?> getMedicalData(@PathVariable("id") Long id) {
        logger.info("Started getMedicalData MedicalDataController!");
        try {
            logger.info("Success getMedicalData MedicalDataController!");
            return ResponseEntity.ok(medicalDataService.findMedicalDataById(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getMedicalData MedicalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PutMapping(value = "/medicalData/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMedicalData(@RequestBody MedicalDataDto medicalDataDto) {
        logger.info("Started updateMedicalData MedicalDataController!");
        try {
            logger.info("Success updateMedicalData MedicalDataController!");
            return ResponseEntity.ok(medicalDataService.updateMedicalData(medicalDataMapper.mapToMedicalData(medicalDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed updateMedicalData MedicalDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

}