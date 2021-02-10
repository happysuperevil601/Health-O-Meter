package com.superdevs.HealthOMeter.controllers;

import com.superdevs.HealthOMeter.dto.BioMetricDataDto;
import com.superdevs.HealthOMeter.mappers.BioMetricDataMapper;
import com.superdevs.HealthOMeter.service.BioMetricDataService;
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
public class BioMetricDataController {
    private static final Logger logger = LoggerFactory.getLogger(BioMetricDataController.class);

    @Autowired
    private BioMetricDataService bioMetricDataService;

    @Autowired
    private BioMetricDataMapper bioMetricDataMapper;

    @GetMapping(value = "/bioMetricData")
    public ResponseEntity<?> getAllBioMetricData() {
        logger.info("Started getAllBioMetricData BioMetricDataController!");
        try {
            logger.info("Success getAllBioMetricData BioMetricDataController!");
            return ResponseEntity.ok(bioMetricDataMapper.mapToBioMetricDataDtoList(bioMetricDataService.getAllBioMetricData()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllBioMetricData BioMetricDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid" + e);
        }
    }

    @DeleteMapping(value = "/bioMetricData/{id}")
    public ResponseEntity<?> deleteBioMetricData(@PathVariable("id") Long id) {
        logger.info("Started deleteBioMetricData BioMetricDataController!");
        try {
            bioMetricDataService.deleteBioMetricData(id);
            logger.info("Success deleteBioMetricData BioMetricDataController!");
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed deleteBioMetricData BioMetricDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PostMapping(value = "/bioMetricData")
    public ResponseEntity<?> createBioMetricData(@RequestBody BioMetricDataDto bioMetricDataDto) {
        logger.info("Started createBioMetricData BioMetricDataController!");
        try {
            return ResponseEntity.ok(bioMetricDataService.createBioMetricData(bioMetricDataMapper.mapToBioMetricData(bioMetricDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createBioMetricData BioMetricDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @GetMapping(value = "/bioMetricData/{id}")
    public ResponseEntity<?> getBioMetricData(@PathVariable("id") Long id) {
        logger.info("Started getBioMetricData BioMetricDataController!");
        try {
            logger.info("Success getBioMetricData BioMetricDataController!");
            return ResponseEntity.ok(bioMetricDataService.findBioMetricDataById(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getBioMetricData BioMetricDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PutMapping(value = "/bioMetricData/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateBioMetricData(@RequestBody BioMetricDataDto bioMetricDataDto) {
        logger.info("Started updateBioMetricData BioMetricDataController!");
        try {
            logger.info("Success updateBioMetricData BioMetricDataController!");
            return ResponseEntity.ok(bioMetricDataService.updateBioMetricData(bioMetricDataMapper.mapToBioMetricData(bioMetricDataDto)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed updateBioMetricData BioMetricDataController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

}
